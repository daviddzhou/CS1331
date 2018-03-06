public class Planet extends AstronomicalObject {
    final int radius;
    private int orbitCount;

	/**
	* Default empty Planet constructor
	*/
	public Planet() {
		super();
	}

	/**
	* Default Planet constructor - need to figure out how to incorporate final int into constructor
	*/
	public Planet(String name, int radius, int orbitCount) {
		super(this.name);

		this.orbitCount = orbitCount;
	}

	/**
	* Create string representation of Planet for printing
	* @return
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
	* @return
	*/
	public int getOrbitCount() {
		return orbitCount;
	}

	/**
	* Sets new value of orbitCount
	* @param
	*/
	public void setOrbitCount(int orbitCount) {
		this.orbitCount = orbitCount;
	}
}
