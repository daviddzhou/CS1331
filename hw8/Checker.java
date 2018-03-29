import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
/**
*@author David Zhou
*@version 1.0
* this class contains methods to assist in text analyzation
*/
public class Checker extends TextCheck {
    // Initializing counters
    private static int goodCount;
    private static int badCount;

    /**
    *@param file linearized string of file contents
    *@return number of sentences
    */
    public static int sentenceAnalyze(String file) {
        String[] abb = file.split("\\s+");
        String[] abbNorm = file.split("\\s+");
        String[] finalabb;
        int index = 0;
        String[] arrayAbb = {"Mr.", "Mrs.", "Ms.", "Dr.", "Jr.", "Sr.", "St.",
            "Am.", "Pm.", "am.", "pm.", "Etc.", "Mt.", "Ct.",
            "Mon.", "Tue.", "Wed.", "Thu.", "Fri.", "Sat.", "Sun.",
            "Jan.", "Feb.", "Mar.", "Jun.", "Jul.", "Apr.",
            "Aug.", "Oct.", "Nov.", "Dec.",
            "Ave.", "Ln.", "Pl.", "Pt.", "R.d", "A.S.A.P.", "R.S.V.P."};
        for (int i = 0; i < abb.length; i++) {
            for (String abbrev : arrayAbb) {
                if (abb[i].equals(abbrev)) {
                    abb[i] = "_";
                }
            }
        }

        boolean delPunct = false;
        for (int i = 0; i < abb.length; i++) {
            if (abb[i].charAt(0) == '\"'
                && !(abb[i].charAt(abb[i].length() - 1) == '\"')) {
                delPunct = true;
            } else if (abb[i].charAt(abb[i].length() - 1) == '\"') {
                delPunct = false;
            }

            if (delPunct) {
                abb[i] = abb[i].replaceAll("[\\.\\?\\!]", "a");
            }
        }

        ArrayList<String> sentences = new ArrayList<String>();
        ArrayList<Integer> punctIndex = new ArrayList<Integer>();
        String sent = "";
        for (int x = 0; x < abb.length; x++) {
            if (abb[x].contains("?") || abb[x].contains("!")
                || abb[x].contains(".")) {
                punctIndex.add(x);
            }
        }

        ArrayList<String> sentFinal = new ArrayList<String>();
        String sentence = "";
        for (int x = 0; x < abbNorm.length; x++) {
            if (!punctIndex.contains(x)) {
                sentence += " " + abbNorm[x];
            } else {
                sentence += " " + abbNorm[x];
                sentFinal.add(sentence);
                sentence = "";
            }
        }

        return sentFinal.size();
    }
    /**
    *@param file linearized string of file contents
    *@return longest sentence
    */
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

    /**
    *@param word word you are looking for
    *@param str linearized string of file contents
    *@return number of occurences of word
    */
    public static int countSubstring(String word, String str) {
        int count = 0;
        Pattern p = Pattern.compile("\\b" + word + "\\b");
        Matcher m = p.matcher(str);
        while (m.find()) {
            count++;
        }
        return count;
    }

    /**
    *@param word word you are looking for
    *@param str linearized string of file contents
    */
    public static void findGoodWord(String word, String str) {
        Pattern p = Pattern.compile("\\b" + word + "\\b");
        Matcher m = p.matcher(str);
        while (m.find()) {
            goodCount++;
        }
    }

    /**
    *@param word word you are looking for
    *@param str linearized string of file contents
    */
    public static void findBadWord(String word, String str) {
        Pattern p = Pattern.compile("\\b" + word + "\\b");
        Matcher m = p.matcher(str);
        while (m.find()) {
            badCount++;
        }
    }

    /**
    * Returns value of goodCount
    * @return goodcount value
    */
    public static int getGoodCount() {
        return goodCount;
    }


    /**
    * Returns value of badCount
    * @return badcount value
    */
    public static int getBadCount() {
        return badCount;
    }

}
