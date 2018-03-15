/**
 * The main driver for Grad
 *
 * @author David Zhou
 * @version 1.0
 */
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
    * @param name name of the users
    * @param creditHours num creditHours they have
    * @param inState whether they are instate
    * @param almaMater the almaMater of the grad
    * @param gradYear the year that they graduated
    */
	public Grad(String name, int creditHours, boolean inState, String almaMater, int gradYear) {
		super(name, creditHours, inState);
		this.almaMater = almaMater;
		this.gradYear = gradYear;
	}

	/**
	* Returns value of almaMater
	* @return value of almaMater
	*/
	public String getAlmaMater() {
		return almaMater;
	}

	/**
	* Returns value of gradYear
	* @return value of gradYear
	*/
	public int getGradYear() {
		return gradYear;
	}

    /**
    *@param other the user defined
    *@return comparable integer
    */
    @Override
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
