public class Grad extends Student implements Alumnus {
    private String almaMater;
    private int gradYear;

	/**
	* Default empty Grad constructor
	*/
	public Grad() {
		super();
	}

	/**
	* Default Grad constructor
	*/
	public Grad(String almaMater, int gradYear, String name, int creditHours, boolean inState) {
		super(name, creditHours, inState);
		this.almaMater = almaMater;
		this.gradYear = gradYear;
	}

	/**
	* Returns value of almaMater
	* @return
	*/
	public String getAlmaMater() {
		return almaMater;
	}

	/**
	* Returns value of gradYear
	* @return
	*/
	public int getGradYear() {
		return gradYear;
	}
}
