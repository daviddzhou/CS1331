public class Planet extends AstronomicalObject {
    protected final double radius;
    protected int orbitCount;

	/**
	* Default empty Planet constructor
	*/
	public Planet() {
		super();
	}

	/**
	* Default Planet constructor - need to figure out how to incorporate final int into constructor
	*/
	public Planet(String name, double radius, int orbitCount) {
		super(this.name);

		this.orbitCount = orbitCount;
	}

	/**
	* Create string representation of Planet for printing
	* @return string representation of Planet for printing
	*/
	@Override
	public String toString() {
		return "Planet" + super.toString() + "." + "Radius:" + radius + "."
            + "Orbits completed:" + orbitCount;
	}

    //how can you implement if your star cannot have planets without listing

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
	* @param orbitCount integer value of orbitCount that you will be setting it to
	*/
	public void setOrbitCount(int orbitCount) {
		this.orbitCount = orbitCount;
	}
}
