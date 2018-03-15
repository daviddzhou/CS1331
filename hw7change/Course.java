/**
 * Represents a Course class
 * @author John Ryu
 * @version 1.0
 */


public class Course implements Comparable<Course> {
    private String name;
    private int courseCode;
    private Instructor instructor;
    private Student[] students;

    /**
     * Empty constructor
     */

    public Course() {

    }

    /**
     * Creates a Course that has a name, courseCode, Instructor object, and
        Student object array.
     * @param name Name of course
     * @param courseCode The course code.
     * @param instructor object Instructor
     * @param students Student object array
     */

    public Course(String name, int courseCode, Instructor instructor,
        Student[] students) {
        this.name = name;
        this.courseCode = courseCode;
        this.instructor = instructor;
        this.students = students;
    }

    /**
     * Method returns the Instructor's name
     * @return name of Instructor
     */

    public String getInstructorName() {
        return instructor.getName();
    }

    /**
     * Method returns the Course code
     * @return Course code
     */

    public int getCourseCode() {
        return courseCode;
    }

    /**
     * Method returns the instructor object of the course
     * @return Instructor of course
     */

    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * Method returns the name of the course
     * @return name of the course
     */

    public String getName() {
        return name;
    }

    /**
     * Method returns a Student object array
     * @return Student array
     */

    public Student[] getStudents() {
        return students;
    }

    /**
     * Overrides Compare interface's compareTo method
     * @param other Course class object
     * @return Integer
     */

    @Override
    public int compareTo(Course other) {
        if (this.courseCode == other.courseCode) {
            return name.compareTo(other.getInstructorName());
        } else if (this.courseCode > other.courseCode) {
            return 1;
        } else {
            return -1;
        }
    }


}
