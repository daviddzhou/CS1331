import javafx.scene.image.Image;
import java.util.Random;

/**
*This class generates the pictures in a random order
*@author David Zhou
*@version 1.123
*/
public class ImageGen extends Slot {
    private static Image random = new Image("file:Question1.png", 110,
        100, false, false);
    private static Image bell = new Image("file:Bell-512.png", 110,
        100, false, false);
    private static Image grape = new Image("file:Grape-512.png", 110,
        100, false, false);
    private static Image cherry = new Image("file:Cherry-512.png", 110,
        100, false, false);
    private static Image line1 = new Image("file:Line1.png", 110,
        100, false, false);
    private static Image line2 = new Image("file:Line2.png", 110,
        100, false, false);
    private static Image line3 = new Image("file:Line3.png", 110,
        100, false, false);
    private static Image line4 = new Image("file:Line4.png", 110,
        100, false, false);
    private static Image line5 = new Image("file:Line5.png", 110,
        100, false, false);
    private static Image[] img = {bell, grape, cherry, line1,
        line2, line3, line4, line5};
    private static Image[] testImg = {bell, grape, cherry};
    private static Image[] lines = {line1, line2, line3, line4, line5};


    /**
    *This method changes the images
    *@return the image you want
    */
    public static Image changer() {
        Random rand = new Random();
        random = img[rand.nextInt(img.length)];
        return random;
    }

    /**
    *Tests the changes you make
    *@return the image you want
    */
    public static Image testChanger() {
        Random rand2 = new Random();
        random = testImg[rand2.nextInt(testImg.length)];
        return random;
    }

    /**
    *The method takes in three parameters and assigns scores
    *@param a image 1
    *@param b image 2
    *@param c image 3
    *@return the number of winnings
    */
    public static int winnings(Image a, Image b, Image c) {
        if ((a.equals(bell)) && (b.equals(bell)) && (c.equals(bell))) {
            return 10;
        } else if ((a.equals(grape)) && (b.equals(grape))
            && (c.equals(grape))) {
            return 7;
        } else if ((a.equals(cherry)) && (b.equals(cherry))
            && (c.equals(cherry))) {
            return 5;
        }
        Image[] cherryCheck = {a, b, c};
        int cherryCount = 0;
        int lineCount = 0;
        for (Image i : cherryCheck) {
            if (i.equals(cherry)) {
                cherryCount++;
            } else {
                for (Image j : lines) {
                    if (i.equals(j)) {
                        lineCount++;
                    }
                }
            }
        }
        if ((cherryCount == 2) && (lineCount == 1)) {
            return 3;
        } else if ((cherryCount == 1) && (lineCount == 2)) {
            return 1;
        } else {
            return 0;
        }
    }
}
