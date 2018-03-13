public class Student extends User {
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
	public Student(int creditHours, boolean inState) {
		super();
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
	public boolean isInState() {
		return inState;
	}
}
