/**
* @author David Zhou
* @version 1.0
*/

public class GasGiant extends Planet {
    private int numStorms;

    /**
    * Default empty GasGiant constructor
    */
    public GasGiant() {
        super();
    }

    /**
    * Default GasGiant constructor
    * @param name the name of the Planet that GasGiant extends
    * @param rad the finalized radius
    * @param orbits the initial orbitCount of the Planet
    * @param storms the initial number of storms
    */
    public GasGiant(String name, double rad, int orbits, int storms) {
        super(name, radius, orbitCount);
        this.numStorms = storms;
    }

    /**
    *Create method to increment numStorms variable
    */
    @Override
    public void orbit() {
        orbitCount++;
        numStorms += 3;
    }

    /**
    * Create string representation of GasGiant for printing
    * @return string representation OF GasGiant for printing
    */
    @Override
    public String toString() {
        return "Gas Giant " + super.toString() + "Number of storms: "
            + numStorms;
    }

    /**
    * Returns value of numStorms
    * @return value of numStorms
    */
    public int getNumStorms() {
        return numStorms;
    }

    /**
    * Sets new value of numStorms
    * @param numStorms number of storms in the selected planet
    */
    public void setNumStorms(int numStorms) {
        this.numStorms = numStorms;
    }
}
