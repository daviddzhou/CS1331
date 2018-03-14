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
	public boolean getHasTenure() {
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

    @Override
    public int compareTo(Instructor other) {
        try {
            if (this.hasTenure == other.getHasTenure()) {
                if (this.yearsTeaching == other.getYearsTeaching()) {
                    super.compareTo(other);
                } else if (this.yearsTeaching > other.getYearsTeaching()) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (this.hasTenure) {
                return 1;
            }
            return -1;
        } catch (Exception e) {
            System.out.println("Cannot be casted to Instructor!");
            return 0;
        }
    }
}
