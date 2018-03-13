public class Instructor extends User implements Alumnus {
    private String yearsTeaching;
    private boolean hasTenure;
    private String almaMater;
    private int gradYear;

	/**
	* Default empty Instructor constructor
	*/
	public Instructor() {
		super();
	}

	/**
	* Default Instructor constructor
	*/
	public Instructor(String name, String yearsTeaching, boolean hasTenure, String almaMater, int gradYear) {
		super(name);
		this.yearsTeaching = yearsTeaching;
		this.hasTenure = hasTenure;
		this.almaMater = almaMater;
		this.gradYear = gradYear;
	}

	/**
	* Returns value of yearsTeaching
	* @return
	*/
	public String getYearsTeaching() {
		return yearsTeaching;
	}

	/**
	* Returns value of hasTenure
	* @return
	*/
	public boolean isHasTenure() {
		return hasTenure;
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
