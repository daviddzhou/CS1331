public class Undergrad extends Student {
    private Year year;

	/**
	* Default empty Undergrad constructor
	*/
	public Undergrad() {
		super();
	}

	/**
	* Default Undergrad constructor
	*/
	public Undergrad(Year year, String name, int creditHours, boolean inState) {
		super(name, creditHours, inState);
		this.year = year;
	}

	/**
	* Returns value of year
	* @return
	*/
	public Year getYear() {
		return year;
	}
}
