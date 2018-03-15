/**
 * Represents a Instructor class object
 * @author John Ryu
 * @version 1.0
 */

public class Instructor extends User implements Alumnus {
    private int yearsTeaching;
    private boolean hasTenure;
    private String almaMater;
    private int gradYear;

    /**
     * Empty constructor in case of empty input.
     */

    public Instructor() {
        super();
    }

    /**
     * Creates an Instructor with a name, number of years taught, if instructor
        is tenured, his/her alma mater, and graduation year.
     * @param name Name of Instructor
     * @param yearsTeaching Number of years taught
     * @param hasTenure Whether instructor is tenured
     * @param almaMater Instructor's Alma Mater.
     * @param gradYear Instructor's graduation year.
     */

    public Instructor(String name, int yearsTeaching, boolean hasTenure,
        String almaMater, int gradYear) {
        super(name);
        this.yearsTeaching = yearsTeaching;
        this.hasTenure = hasTenure;
        this.almaMater = almaMater;
        this.gradYear = gradYear;
    }

    /**
     * Method returns the number of years instructor has taught.
     * @return number of years taught
     */

    public int getYearsTeaching() {
        return yearsTeaching;
    }

    /**
     * Method returns if instructor is tenured
     * @return hasTenure
     */

    public boolean getHasTenure() {
        return hasTenure;
    }

    /**
     * Method returns Instructor's alma mater
     * @return almaMater
     */

    public String getAlmaMater() {
        return almaMater;
    }

    /**
     * Method returns Instructor's graduation year
     * @return gradYear
     */

    public int getGradYear() {
        return gradYear;
    }

    /**
     * Overrides User's compareTo method
     * @param other Passes in user object
     * @return integer that shows comparison
     */

    @Override
    public int compareTo(User other) {
        if (other instanceof Instructor) {
            Instructor casted = (Instructor) other;
            if (hasTenure == casted.getHasTenure()) {
                if (yearsTeaching > casted.getYearsTeaching()) {
                    return 1;
                } else if (yearsTeaching < casted.getYearsTeaching()) {
                    return -1;
                } else if (yearsTeaching == casted.getYearsTeaching()) {
                    return 0;
                } else {
                    super.compareTo(other);
                }
            } else if (hasTenure != casted.getHasTenure()) {
                if (hasTenure) {
                    return 1;
                } else if (casted.getHasTenure()) {
                    return -1;
                }
            }
        } else {
            return
                this.getClass().getName().compareTo(other.getClass().getName());
        }
        return 0;
    }

}
