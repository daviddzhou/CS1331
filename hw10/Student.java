/**
 * Class that holds information about a student.
 * @author Luke Senseney
 * @version 1.0 Apr 10, 18
 **/
public class Student implements Comparable<Student> {
    private int testGrade;
    private int homeworkGrade;
    private String name;

    /**
     * Creates a new Student.
     * @param name  name for student.
     * @param testGrade the students test grade.
     * @param homeworkGrade the students homework grade.
     */
    public Student(String name, int testGrade, int homeworkGrade) {
        this.name = name;
        this.testGrade = testGrade;
        this.homeworkGrade = homeworkGrade;
    }

    /**
     * @return  The students test grade.
     */
    public int getTestGrade() {
        return testGrade;
    }

    /**
     * @param testGrade The new test grade for the student
     */
    public void setTestGrade(int testGrade) {
        this.testGrade = testGrade;
    }
    /**
     * @return  The students homework grade
     */
    public int getHomeworkGrade() {
        return homeworkGrade;
    }

    /**
     * @param homeworkGrade The new homework grade
     */
    public void setHomeworkGrade(int homeworkGrade) {
        this.homeworkGrade = homeworkGrade;
    }

    /**
     * @return  the Student's name
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            return name.equals(((Student) o).name);
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Student s) {
        return name.compareTo(s.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString(){
        return "[" + name + " Test:" + testGrade + " Homework:" + homeworkGrade + "]";
    }
}
