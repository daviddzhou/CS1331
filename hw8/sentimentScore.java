import java.util.regex.*;
public class sentimentScore extends TextCheck {
    private static int goodCount;
    private static int badCount;

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
