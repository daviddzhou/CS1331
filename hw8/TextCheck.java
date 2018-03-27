import java.util.Scanner;
import java.io.*;

public class TextCheck {
    public static void main(String[] args) {

        String longestSentence = null;
        boolean retry = false;
        String fileContents = null;
        String word = null;
        String line = null;
        String lowerFile = null;
        int totalSentimentScore;


        Scanner scanner = new Scanner(System.in);
        while (!retry) {
            // The name of the file to open.
            System.out.println("What is the name of source file to analyze?");
            String fileName = scanner.nextLine();
            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader =
                    new FileReader(fileName);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

                fileContents =
                    new Scanner(new File(fileName)).useDelimiter("\\Z").next();

                longestSentence =
                    SentenceCheck.getLongestString(fileContents);

                while ((line = bufferedReader.readLine()) != null) {
                    SentenceCheck.analyze(line);
                    WordCheck.analyze(line);
                }

                // Break the loop
                retry = true;
                // Always close files.
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.err.println("Sorry, but that file doesnt exist."
                    + "Please retype the name.");
                continue;
            } catch (IOException ex) {
                System.err.println("Error reading file");
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
                        targetCheck.countSubstring(word, lowerFile);
                    writer.println(word + ": " + targetCount);
                }

                writer.close();
                // Break the loop
                retry = true;
                // Always close files.
                bufferedTarget.close();
            } catch (FileNotFoundException ex) {
                System.err.println("Sorry, but that file doesnt exist."
                    + "Please retype the name.");
            } catch (IOException ex) {
                System.err.println("Error reading file");
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
                sentimentScore.findGoodWord(word, lowerFile);
            }
            // FileReader reads text files in the default encoding.
            FileReader badReader = new FileReader(badName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedBad = new BufferedReader(badReader);
            while ((word = bufferedBad.readLine()) != null) {
                sentimentScore.findBadWord(word, lowerFile);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Sorry, but that file doesnt exist."
                + "Please retype the name.");
        } catch (IOException ex) {
            System.err.println("Error reading file");
        }

        System.out.println("\nAnalyzing");

        int sentenceCount = SentenceCheck.getSentenceCount();
        int wordCount = WordCheck.getCountWord();
        int positiveCount = sentimentScore.getGoodCount();
        int negativeCount = sentimentScore.getBadCount();
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
