/**
* Subclass of AstronomicalObject that describes planet
* @author David Zhou
* @version 1.0
*/

public class Planet extends AstronomicalObject {
    protected final double aRADIUS;
    protected int orbitCount;

    /**
    * Default empty Planet constructor
    */
    public Planet() {
        super();
        aRADIUS = 0;
    }

    /**
    * Default Planet constructor
    * @param name name of the AstronomicalObject
    * @param rad the unchangeable RADIUS that is entered
    * @param orbits the initial orbitCount
    */
    public Planet(String name, double rad, int orbits) {
        super(name);
        aRADIUS = rad;
        orbitCount = orbits;
    }

    /**
    * Create string representation of Planet for printing
    * @return string representation of Planet for printing
    */
    @Override
    public String toString() {
        return "Planet " + super.toString() + "Radius: "
            + aRADIUS + "." + " Orbits completed: " + orbitCount;
    }


    /**
    * this method increments the orbit by 1
    */
    public void orbit() {
        orbitCount++;
    }

    /**
    * Returns value of orbitCount
    * @return value of orbitCount
    */
    public int getOrbitCount() {
        return orbitCount;
    }

    /**
    * Sets new value of orbitCount
    * @param orbitCount integer value of orbitCount
    */
    public void setOrbitCount(int orbitCount) {
        this.orbitCount = orbitCount;
    }
}
