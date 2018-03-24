public class SentenceCheck extends TextCheck {
    // Initializing counters
    private static int sentenceCount = 0;
    public static int analyze(String line) {
        // [!?.:]+ is the sentence delimiter in java
        String[] sentenceList = line.split("[!?.:]+");
        sentenceCount += sentenceList.length;
        return sentenceCount;
    }

    public static String getLongestString(String file) {
        String[] sentenceList = file.split("[!?.:]+");
        int maxLength = 0;
        String longestString = null;
        for (String s : sentenceList) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                longestString = s;
            }
        }
        return longestString;
    }

    /**
    * Returns value of sentenceCount
    * @return
    */
    public static int getSentenceCount() {
        return sentenceCount;
    }

}
