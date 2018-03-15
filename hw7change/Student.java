/**
 * Represents a Student Object
 * @author John Ryu
 * @version 1.0
 */

public abstract class Student extends User {

    private int creditHours; // The number of credit hours the student has taken
    private boolean inState; // Whether the student is from in state or not

    /**
     * Empty constructor
     */

    public Student() {
        super();
    }

    /**
     * Creates a student object with following instance vars.
     * @param creditHours Number of credit hours student has taken
     * @param inState Whether student is in-state or not.
     * @param name Name of student
     */

    public Student(int creditHours, boolean inState, String name) {
        super(name);
        this.creditHours = creditHours;
        this.inState = inState;
    }

    /**
     * Method returns the number of credit hours student has taken.
     * @return creditHours
     */

    public int getCreditHours() {
        return creditHours;
    }

    /**
     * Method returns whether or not student is in state.
     * @return inState
     */

    public boolean getInState() {
        return inState;
    }

    /**
     * Overrides User's compareTo method.
     * @param other User object that is passed in.
     * @return An integer that describes comparison
     */

    public int compareTo(User other) {
        if (other instanceof Student) {
            Student casted = (Student) other;
            if (creditHours < casted.getCreditHours()) {
                return 1;
            } else if (creditHours > casted.getCreditHours()) {
                return -1;
            } else {
                if (inState == casted.getInState()) {
                    super.compareTo(other);
                } else if (inState) {
                    return 1;
                } else if (casted.getInState()) {
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
