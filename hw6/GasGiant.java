public class GasGiant extends Planet {
    private int numStorms;

	/**
	* Default empty GasGiant constructor
	*/
	public GasGiant() {
		super();
	}

	/**
	* Default GasGiant constructor - how can you implement code from your previous superclass to make this work
	*/
	public GasGiant(int numStorms) {
		super();
		this.numStorms = numStorms;
	}

    /**
    *Create method to increment numStorms variable
    */
    @Override
    public void orbit() {
        numStorms += 3;
    }

	/**
	* Create string representation of GasGiant for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Gas Giant " + super.toString() + "Number of storms: " + numStorms;
	}

	/**
	* Returns value of numStorms
	* @return
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
