/**
 * Represents a Graduate Student
 * @author John Ryu
 * @version 1.0
 */

public class Grad extends Student implements Alumnus {

    private String almaMater; // Where the instructor graduated from
    private int gradYear; // The year the instructor graduated

    /**
     * Empty Constructor
     */

    public Grad() {
        super();
    }

    /**
     * Creates a Graduate Student object with the following instance vars.
     * @param name Name of grad student.
     * @param creditHours Number of credits grad has taken.
     * @param inState Whether or not grad is in-state.
     * @param almaMater Grad Student's alma mater.
     * @param gradYear Grad Student's graduation year.
     */

    public Grad(String name, int creditHours, boolean inState, String almaMater,
        int gradYear) {
        super(creditHours, inState, name);
        this.almaMater = almaMater;
        this.gradYear = gradYear;
    }

    /**
     * Method returns the alma mater of grad student.
     * @return almaMater
     */

    public String getAlmaMater() {
        return almaMater;
    }

    /**
     * Method returns the graduation year of grad student.
     * @return gradYear
     */

    public int getGradYear() {
        return gradYear;
    }

    /**
     * Overrides the compareTo method in Student class
     * @param other User object passed in.
     * @return Integer describing comparison.
     */

    public int compareTo(User other) {
        if (other instanceof Grad) {
            Grad casted = (Grad) other;
            if (gradYear < casted.getGradYear()) {
                return -1;
            } else if (gradYear > casted.getGradYear()) {
                return 1;
            } else {
                super.compareTo(other);
            }
        } else {
            return
                this.getClass().getName().compareTo(other.getClass().getName());
        }
        return 0;
    }

}
