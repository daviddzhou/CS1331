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
	*/
	public Student(String name, int creditHours, boolean inState) {
		super(name);
		this.creditHours = creditHours;
		this.inState = inState;
	}
    //same as the previous class how do you create a nonconcrete object

	/**
	* Returns value of creditHours
	* @return
	*/
	public int getCreditHours() {
		return creditHours;
	}

	/**
	* Returns value of inState
	* @return
	*/
	public boolean getInState() {
		return inState;
	}

    public int compareTo (User other) {
        if (other instanceof Student) {
            Student casted = (Student) other;
            if (this.creditHours < casted.getCreditHours()) {
                return 1;
            } else if (this.creditHours > casted.getCreditHours()) {
                return -1;
            } else {
                if (this.inState == casted.getInState()) {
                    super.compareTo(other);
                } else if(this.inState) {
                    return 1;
                } else if (casted.getInState()) {
                    return -1;
                }
            }
        } else {
            return this.getClass().getName().compareTo(other.getClass().getName());
        }
        return 0;
    }
}
