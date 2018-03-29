import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
public class Checker extends TextCheck {
    // Initializing counters
    private static int goodCount;
    private static int badCount;


    public static int sentenceAnalyze(String file) {
        String[] abb = file.split("\\s+");
        String[] finalabb;
        int index = 0;
        String[] arrayAbb = {"mr", "mrs", "ms", "dr", "jr", "sr", "st",
            "am", "pm", "etc", "mt", "ct", "fri", "mon", "tue", "wed",
            "fri", "sat", "sun", "jan", "feb", "mar", "jun", "jul", "apr",
            "aug", "oct", "nov", "dec", "in", "ft", " m", "cm", "km", "mi",
            "ave", "ln", "pl", "pt", "rd", "a.s.a.p"};
        for (int i = 0; i < abb.length; i++) {
            for (String abbrev : arrayAbb) {
                if (abb[i].toLowerCase() == abbrev) {
                    abb[i] = "_";
                }
            }
        }

        String sentence1 = null;
        ArrayList<String> sentences = new ArrayList<String>();
        int counterforloop = 0;
        for (int j = 0; j < abb.length; j++) {
            if (abb[j].contains("?") || abb[j].contains("!") || abb[j].contains(".")) {
                index = j;
                for (int k = counterforloop; k < index; k++) {
                    sentence1 += abb[k];
                }
                counterforloop = j;
                sentences.add(sentence1);
            }
        }
        return sentences.size();
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
