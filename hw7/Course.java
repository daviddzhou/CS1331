public class Course implements Comparable<Course>{
    private String name;
    private int courseCode;
    private Instructor instructor;
    private Student[] students;

	/**
	* Default empty Course constructor
	*/
	public Course() {
	}

	/**
	* Default Course constructor
	*/
	public Course(String name, int courseCode, Instructor instructor, Student[] students) {
		this.name = name;
		this.courseCode = courseCode;
		this.instructor = instructor;
		this.students = students;
	}

    //implement actual method to get the Insctuctor name
    public String getInstructorName() {
        return instructor.getName();
    }

	/**
	* Returns value of name
	* @return
	*/
	public String getName() {
		return name;
	}

	/**
	* Returns value of courseCode
	* @return
	*/
	public int getCourseCode() {
		return courseCode;
	}

	/**
	* Returns value of instructor
	* @return
	*/
	public Instructor getInstructor() {
		return instructor;
	}

    public int compareTo(Course other) {
        if (this.courseCode > other.getCourseCode()) {
            return 1;
        } else if (this.courseCode < other.getCourseCode()) {
            return -1;
        } else {
            return (this.getInstructorName().compareTo(other.getInstructorName()));
        }
    }
}
