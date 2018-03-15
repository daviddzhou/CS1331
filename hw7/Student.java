/**
* The main driver for Student
*
* @author David Zhou
* @version 1.0
*/
public abstract class Student extends User {
    private int creditHours;
    private boolean inState;

    /**
    * Default empty Student constructor
    */
    public Student() {
        super();
    }

    /**
    * Default Student constructor
    * @param name name of the users
    * @param creditHours num creditHours they have
    * @param inState whether they are instate
    */
    public Student(String name, int creditHours, boolean inState) {
        super(name);
        this.creditHours = creditHours;
        this.inState = inState;
    }

    /**
    * Returns value of creditHours
    * @return value of creditHours
    */
    public int getCreditHours() {
        return creditHours;
    }

    /**
    * Returns value of inState
    * @return value of inState
    */
    public boolean getInState() {
        return inState;
    }

    /**
    *@param other the user defined
    *@return comparable integer
    */
    @Override
    public int compareTo(User other) {
        if (other instanceof Student) {
            Student casted = (Student) other;
            if (creditHours < casted.getCreditHours()) {
                return 1;
            } else if (creditHours > casted.getCreditHours()) {
                return -1;
            } else {
                if (inState == casted.getInState()) {
                    return super.compareTo(other);
                } else if (inState) {
                    return 1;
                } else if (casted.getInState()) {
                    return -1;
                } else {
                    return super.compareTo(other);
                }
            }
        } else {
            return this.getClass().getName()
                .compareTo(other.getClass().getName());
        }
    }
}
