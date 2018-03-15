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
	public Grad(String name, int creditHours, boolean inState, String almaMater, int gradYear) {
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

    public int compareTo(User other) {
        if (other instanceof Grad) {
            Grad casted = (Grad) other;
            if (gradYear < casted.getGradYear()) {
                return -1;
            } else if(gradYear > casted.getGradYear()) {
                return 1;
            } else {
                super.compareTo(other);
            }
        } else {
            return this.getClass().getName().compareTo(other.getClass().getName());
        }
        return 0;
    }
}
