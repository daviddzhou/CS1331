import java.util.regex.*;
public class targetCheck extends TextCheck {

    public static int countSubstring(String word, String str) {
        int count = 0;
        Pattern p = Pattern.compile("\\b" + word + "\\b");
        Matcher m = p.matcher(str);
        while (m.find()) {
            count++;
        }
        return count;
    }

}
