/**
* @author David Zhou
* @version 1.0
*/

public class Planet extends AstronomicalObject {
    protected static final double radius;
    protected static int orbitCount;

    /**
    * Default empty Planet constructor
    */
    public Planet() {
        super();
    }

    /**
    * Default Planet constructor
    * @param name name of the AstronomicalObject
    * @param rad the unchangeable radius that is entered
    * @param orbits the initial orbitCount
    */
    public Planet(String name, double rad, int orbits) {
        super(name);
        orbitCount = orbits;
    }

    /**
    * Create string representation of Planet for printing
    * @return string representation of Planet for printing
    */
    @Override
    public String toString() {
        return "Planet" + super.toString() + "." + "Radius:"
            + radius + "." + "Orbits completed:" + orbitCount;
    }

    //how can you implement if your star cannot have planets

    /**
    * @return the orbitCount that is newly incremented
    */
    public int orbit() {
        orbitCount++;
        return orbitCount;
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
