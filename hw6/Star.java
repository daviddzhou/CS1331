/**
* @author David Zhou
* @version 1.0
*/

public class Star extends AstronomicalObject {
    private Color color;
    private boolean isSun;
    private String isSunString;
    private int id;


    /**
    * Default empty Star constructor
    */
    public Star() {
        super();
    }

    /**
    * Default Star constructor
    * @param name name of the AstronomicalObject
    * @param id id of the color in the enumerated class
    */
    public Star(String name, int id) {
        super(name);
        this.id = id;
        color = Color.getColorById(id);
    }

    /**
    * @return the color that you get from the id submitted
    */
    public Color getColor() {
        color = Color.getColorById(id);
        return color;
    }

    /**
    * Create string representation of Star for printing
    * @return string representation of Star for printing
    */
    @Override
    public String toString() {
        if (color == Color.RED) {
            isSun = false;
        } else {
            isSun = true;
        }
        if (isSun) {
            return "Star " + name + ". " + "Color: " + color + ". "
                + "This Star can have planets";
        } else {
            return "Star " + name + ". " + "Color: " + color + ". "
                + "This Star can't have planets";
        }
    }

    /**
    * Sets new value of color
    * @param color the enum color that you want to set your current color to
    */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
    * Returns value of isSun
    * @return value of isSun
    */
    public boolean isIsSun() {
        return isSun;
    }

    /**
    * Sets new value of isSun
    * @param isSun boolean value that says whether it can be a sun or not
    */
    public void setIsSun(boolean isSun) {
        this.isSun = isSun;
    }
}
