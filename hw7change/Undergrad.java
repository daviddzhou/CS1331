/**
 * Represents an undergrad student
 * @author John Ryu
 * @version 1.0
 */

public class Undergrad extends Student {

    private Year year; // The class standing of the student

    /**
     * Empty constructor
     */

    public Undergrad() {
        super();
    }

    /**
     * Creates an Undergrad object with following instance vars.
     * @param name Name of undergraduate
     * @param creditHours Number of credit hours undergrad has.
     * @param inState Whether or not the undergrad is in-state.
     * @param year The year type of the undergrad.
     */

    public Undergrad(String name, int creditHours, boolean inState, Year year) {
        super(creditHours, inState, name);
        this.year = year;
    }

    /**
     * Method returns the year type of the undergraduate.
     * @return year
     */

    public Year getYear() {
        return year;
    }

    /**
     * Overrides the compareTo method in Student class
     * @param other User object passed in.
     * @return Integer that describes comparison.
     */

    @Override
    public int compareTo(User other) {
        if (other instanceof Undergrad) {
            Undergrad casted = (Undergrad) other;
            if (year.ordinal() < casted.getYear().ordinal()) {
                return 1;
            } else if (year.ordinal() > casted.getYear().ordinal()) {
                return -1;
            } else if (year.ordinal() == casted.getYear().ordinal()) {
                super.compareTo(other);
            }
        } else {
            return
                this.getClass().getName().compareTo(other.getClass().getName());
        }
        return 0;
    }

}
