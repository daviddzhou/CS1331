public class WordCheck extends TextCheck {
    private static int countWord = 0;

    public static int analyze(String line) {
        // \\s+ is the space delimiter in java
        String[] wordList = line.split("\\s+");
        countWord += wordList.length;
        return countWord;
    }

    /**
    * Returns value of countWord
    * @return
    */
    public static int getCountWord() {
        return countWord;
    }

}
