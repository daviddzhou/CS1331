public class RockyPlanet extends Planet {
    private boolean hasLife;

	/**
	* Default empty RockyPlanet constructor
	*/
	public RockyPlanet() {
		super();
	}

	/**
	* Default RockyPlanet constructor -> how to implement constructor code
	*/
	public RockyPlanet(String name, double rad, int orbits, boolean canHaveLife) {
		super(this.name);
        super(this.radius);
        super(this.orbitCount);
		this.canHaveLife = hasLife;
	}

    /**
    *Override the boolean for hasLife
    */
    @Override
    public void orbit() {
        if(hasLife == true) {
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
        if(hasLife == true) {
            return "RockyPlanet" + super.toString() + "This planet can have life.";
        } else {
            return "RockyPlanet" + super.toString() + "This planet cannot have life";
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
