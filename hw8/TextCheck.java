//I worked on this with Frankie Kim, Daniel Lee, and Eric Yan
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

/**
*@author David Zhou
*@version 1.0
* this class contains main file which analyzes text files
*/
public class TextCheck {
    /**
    *@param args user input for good and bad txt files
    */
    public static void main(String[] args) {

        String longestSentence = null;
        boolean retry = false;
        String fileContents = null;
        String word = null;
        String line = null;
        String lowerFile = null;
        int totalSentimentScore;
        int wordCount = 0;
        int sentenceCount = 0;


        Scanner scanner = new Scanner(System.in);
        while (!retry) {
            // The name of the file to open.
            System.out.println("What is the name of source file to analyze?");
            String fileName = scanner.nextLine();
            try {

                fileContents =
                    new Scanner(new File(fileName)).useDelimiter("\\Z").next();

                String[] wordList = fileContents.split("\\s+");
                wordCount = wordList.length;

                sentenceCount = Checker.sentenceAnalyze(fileContents);

                longestSentence =
                    Checker.getLongestString(fileContents);

                // Break the loop
                retry = true;
            } catch (IOException ex) {
                System.err.println("Sorry, but that file doesnt exist."
                    + "Please retype the name.");
                continue;
            }
        }

        retry = false;

        while (!retry) {
            //Second file to read
            System.out.println("What is the name of the target words file?");
            String targetName = scanner.nextLine();
            try {
                // FileReader reads text files in the default encoding.
                FileReader targetReader =
                    new FileReader(targetName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedTarget =
                    new BufferedReader(targetReader);

                //replace the fileContents str with lowercase one space
                lowerFile = fileContents.toLowerCase()
                    .replaceAll("[^a-z1-9]+", " ");

                //create the printer
                PrintWriter writer =
                    new PrintWriter("targetCount.txt", "UTF-8");

                //read through the targetWord file
                while ((word = bufferedTarget.readLine()) != null) {
                    int targetCount =
                        Checker.countSubstring(word, lowerFile);
                    writer.println(word + ": " + targetCount);
                }

                writer.close();
                // Break the loop
                retry = true;
                // Always close files.
                bufferedTarget.close();
            } catch (IOException ex) {
                System.err.println("Sorry, but that file doesnt exist."
                    + "Please retype the name.");
            }
        }

        try {
            String goodName = args[0];
            String badName = args[1];
            // FileReader reads text files in the default encoding.
            FileReader goodReader = new FileReader(goodName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedGood = new BufferedReader(goodReader);
            //read through the goodWord file
            while ((word = bufferedGood.readLine()) != null) {
                Checker.findGoodWord(word, lowerFile);
            }
            // FileReader reads text files in the default encoding.
            FileReader badReader = new FileReader(badName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedBad = new BufferedReader(badReader);
            while ((word = bufferedBad.readLine()) != null) {
                Checker.findBadWord(word, lowerFile);
            }
        } catch (IOException ex) {
            System.err.println("Sorry, but that file doesnt exist."
                + "Please retype the name.");
        }

        System.out.println("\nAnalyzing");

        int positiveCount = Checker.getGoodCount();
        int negativeCount = Checker.getBadCount();
        totalSentimentScore = positiveCount - negativeCount;

        System.out.println("Your file contains " + wordCount
            + " words and " + sentenceCount + " sentences.\n");

        System.out.println("The longest sentence in this document is:"
            + longestSentence + "\n");

        System.out.println("Writing out target word counts to file"
            + " targetCount.txt" + "\n");

        if (totalSentimentScore >= 0) {
            System.out.println("The sentiment analysis score is +"
                + totalSentimentScore);
        } else {
            System.out.println("The sentiment analysis score is "
                + totalSentimentScore);
        }

    }
}
