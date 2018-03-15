/**
 * The main driver Course
 *
 * @author David Zhou
 * @version 1.0
 */
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
    *@param name name of Courses
    *@param courseCode int code of Courses
    *@param instructor instructor of class Instructors
    *@param students students array
	*/
	public Course(String name, int courseCode, Instructor instructor, Student[] students) {
		this.name = name;
		this.courseCode = courseCode;
		this.instructor = instructor;
		this.students = students;
	}

    /**
    * @return name of the Instructor
    */
    public String getInstructorName() {
        return instructor.getName();
    }

	/**
	* Returns value of name
	* @return value of name
	*/
	public String getName() {
		return name;
	}

	/**
	* Returns value of courseCode
	* @return value of courseCode
	*/
	public int getCourseCode() {
		return courseCode;
	}

	/**
	* Returns value of instructor
	* @return value of instructor
	*/
	public Instructor getInstructor() {
		return instructor;
	}

    /**
    * Returns value of students
    * @return value of Students
    */
    public Student[] getStudents() {
        return students;
    }

    /**
    *@param other the course defined
    *@return comparable integer
    */
    @Override
    public int compareTo(Course other) {
        if (this.courseCode > other.getCourseCode()) {
            return 1;
        } else if (this.courseCode < other.getCourseCode()) {
            return -1;
        } else {
            return (name.compareTo(other.getInstructorName()));
        }
    }
}
