/**
 * The main driver for Instructor
 *
 * @author David Zhou
 * @version 1.0
 */
public class Instructor extends User implements Alumnus {
    private int yearsTeaching;
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
    public Instructor(String name, int yearsTeaching, boolean hasTenure, String almaMater, int gradYear) {
        super(name);
        this.yearsTeaching = yearsTeaching;
        this.hasTenure = hasTenure;
        this.almaMater = almaMater;
        this.gradYear = gradYear;
    }

    /**
    * Returns value of yearsTeaching
    * @return value of yearsTeaching
    */
    public int getYearsTeaching() {
        return yearsTeaching;
    }

    /**
    * Returns value of hasTenure
    * @return value of hasTenure
    */
    public boolean getHasTenure() {
        return hasTenure;
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
        if (other instanceof Instructor) {
            Instructor casted = (Instructor) other;
            if (this.hasTenure == casted.getHasTenure()) {
                if (this.yearsTeaching > casted.getYearsTeaching()) {
                    return 1;
                } else if(this.yearsTeaching < casted.getYearsTeaching()) {
                    return -1;
                } else if(this.yearsTeaching == casted.getYearsTeaching()) {
                    return 0;
                } else {
                    super.compareTo(other);
                }
            } else if(this.hasTenure != casted.getHasTenure()) {
                if (this.hasTenure) {
                    return 1;
                } else if(casted.getHasTenure()) {
                    return -1;
                }
            } else {
                return this.getClass().getName().compareTo(other.getClass().getName());
            }
        }
        return 0;
    }
}
