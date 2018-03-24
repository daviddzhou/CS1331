import java.util.Scanner;
import java.io.*;

public class TextCheck {
    public static void main (String args[]){
        String longestSentence = null;
        boolean retry = false;
        Scanner scanner = new Scanner(System.in);
        while(!retry) {
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

                String line;

                String fileContents = new Scanner(new File(fileName)).useDelimiter("\\Z").next();

                longestSentence
                    = SentenceCheck.getLongestString(fileContents);

                while((line = bufferedReader.readLine()) != null) {
                    SentenceCheck.analyze(line);
                    WordCheck.analyze(line);
                }

                // Break the loop
                retry = true;
                // Always close files.
                bufferedReader.close();
            }
            catch(FileNotFoundException ex) {
                System.err.println("Sorry, but that file doesnt exist. Please retype the name.");
                continue;
            }
            catch(IOException ex) {
                System.err.println("Error reading file");
                continue;
            }
        }
        retry = false;
        while(!retry) {
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

                // Break the loop
                retry = true;
                // Always close files.
                bufferedTarget.close();
            }
            catch(FileNotFoundException ex) {
                System.err.println("Sorry, but that file doesnt exist."
                    +   "Please retype the name.");
            }
            catch(IOException ex) {
                System.err.println("Error reading file");
            }
        }

        System.out.println("Analyzing");

        int sentenceCount = SentenceCheck.getSentenceCount();
        int wordCount = WordCheck.getCountWord();

        System.out.println("Your file contains " + wordCount
        + " words and " + sentenceCount + " sentences." );

        System.out.println("The longest sentence in this document is:" + longestSentence);
    }
}
