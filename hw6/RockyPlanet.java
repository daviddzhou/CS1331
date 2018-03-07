/**
* @author David Zhou
* @version 1.0
*/

public class RockyPlanet extends Planet {
    private boolean hasLife;

    /**
    * Default empty RockyPlanet constructor
    */
    public RockyPlanet() {
        super();
    }

    /**
    * Default RockyPlanet constructor
    * @param name the name of the Planet that GasGiant extends
    * @param rad the finalized radius
    * @param orbits the initial orbitCount of the Planet
    * @param canHaveLife the boolean value of life
    */
    public RockyPlanet(String name,
                        double rad,
                        int orbits,
                        boolean canHaveLife) {
        super(name, rad, orbitCount);
        hasLife = canHaveLife;
    }

    /**
    *Override the boolean for hasLife
    */
    @Override
    public void orbit() {
        orbitCount++;
        if (hasLife) {
            hasLife = false;
        } else {
            hasLife = true;
        }
    }

    /**
    * Create string representation of RockyPlanet for printing
    * @return string representation of RockyPlanet for printing
    */
    @Override
    public String toString() {
        if (hasLife) {
            return "RockyPlanet " + super.toString()
                + " This planet can have life.";
        } else {
            return "RockyPlanet " + super.toString()
                + " This planet cannot have life.";
        }
    }

    /**
    * Returns value of hasLife
    * @return value of hasLife
    */
    public boolean getHasLife() {
        return hasLife;
    }

    /**
    * Sets new value of hasLife
    * @param hasLife boolean value of whether planet can have life or not
    */
    public void setHasLife(boolean hasLife) {
        this.hasLife = hasLife;
    }
}
