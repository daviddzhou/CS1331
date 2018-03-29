import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Checker extends TextCheck {
    // Initializing counters
    private static int sentenceCount;
    private static int goodCount;
    private static int badCount;


    public static int sentenceAnalyze(String file) {
        // [!?.:]+ is the sentence delimiter in java
        String[] sentenceList = file.split("[!?.]+");
        sentenceCount = sentenceList.length;
        return sentenceCount;
    }

    public static String getLongestString(String file) {
        String[] sentenceList = file.split("[!?.]+");
        int maxLength = 0;
        String longestString = null;
        for (String s : sentenceList) {
            if (s.length() > maxLength) {
                String[] words = s.split("\\s+");
                if (words.length > maxLength) {
                    longestString = s;
                    maxLength = words.length;
                }
            }
        }
        return longestString;
    }

    public static int countSubstring(String word, String str) {
        int count = 0;
        Pattern p = Pattern.compile("\\b" + word + "\\b");
        Matcher m = p.matcher(str);
        while (m.find()) {
            count++;
        }
        return count;
    }

    public static void findGoodWord(String word, String str) {
        Pattern p = Pattern.compile("\\b" + word + "\\b");
        Matcher m = p.matcher(str);
        while (m.find()) {
            goodCount++;
        }
    }

    public static void findBadWord(String word, String str) {
        Pattern p = Pattern.compile("\\b" + word + "\\b");
        Matcher m = p.matcher(str);
        while (m.find()) {
            badCount++;
        }
    }

    /**
    * Returns value of goodCount
    * @return
    */
    public static int getGoodCount() {
        return goodCount;
    }


    /**
    * Returns value of badCount
    * @return
    */
    public static int getBadCount() {
        return badCount;
    }

}
