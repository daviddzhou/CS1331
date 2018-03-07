/**
*Class that describes superclass AstronomicalObject
* @author David Zhou
* @version 1.0
*/

public class AstronomicalObject {
    protected String name;

    /**
    * Default empty AstronomicalObject constructor
    */
    public AstronomicalObject() {
    }

    /**
    * Default AstronomicalObject constructor
    * @param name name of the AstronomicalObject
    */
    public AstronomicalObject(String name) {
        this.name = name;
    }

    /**
    * Create string representation of AstronomicalObject for printing
    * @return string representation of AstronomicalObject for printing
    */
    @Override
    public String toString() {
        return name + ". ";
    }

    /**
    * Returns value of name
    * @return value of name
    */
    public String getName() {
        return name;
    }

    /**
    * Sets new value of name
    * @param name name of the AstronomicalObject
    */
    public void setName(String name) {
        this.name = name;
    }
}
