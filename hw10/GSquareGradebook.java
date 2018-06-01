// Name: David Zhou
// Collaboration: Danny Lee, Eric Yan, Francis Kim, John Ryu

/**
 * This is the gradebook class that adds a student and modifies the student's
 * grades.
 * @author David Zhou
 * @version 1.0
 **/
public class GSquareGradebook {

    private MySortedSet list;

    /**
     * This is the no params constructor for the grade book.
     */
    public GSquareGradebook() {
        list = new MySortedSet();
    }

    /**
     * This is the method that adds a student to the grade book.
     * @param name is the name of the student.
     * @param testGrade is the test grade passed in.
     * @param homeworkGrade is the homework grade passed in.
     */
    public void addStudent(String name, int testGrade, int homeworkGrade) {
        Student newS = new Student(name, testGrade, homeworkGrade);
        if (name.length() != 0) {
            boolean a = list.add(newS);
        }
    }

    /**
     * This is a method that sets the student's test grade to the parameter.
     * @param name is the name of the student.
     * @param testGrade is the student's new test grade.
     */
    public void setTestGrade(String name, int testGrade) {
        if (testGrade >= 0) {
            for (int i = 0; i < list.size(); i++) {
                if (name.equals(((Student) list.getHoldStuds()[i]).getName())) {
                    ((Student) list.getHoldStuds()[i]).setTestGrade(testGrade);
                }
            }
        }
    }

    /**
     * This is a method that sets the student's homework grade to the param.
     * @param name is the name of the student.
     * @param homeworkGrade is the student's new homework grade.
     */
    public void setHomeworkGrade(String name, int homeworkGrade) {
        if (homeworkGrade >= 0) {
            for (int j = 0; j < list.size(); j++) {
                if (name.equals(((Student) list.getHoldStuds()[j]).getName())) {
                    ((Student) list.getHoldStuds()[j])
                        .setHomeworkGrade(homeworkGrade);
                }
            }
        }
    }

    /**
     * This is a method that returns the array of students.
     * @return the array holding the students.
     */
    public Student[] getStudents() {
        int valueCounter = 0;
        Student[] trim;
        for (int k = 0; k < list.size(); k++) {
            if (list.getHoldStuds()[k] != null) {
                valueCounter++;
            }
        }
        trim = new Student[valueCounter];
        for (int l = 0; l < trim.length; l++) {
            trim[l] = (Student) (list.getHoldStuds()[l]);
        }
        return trim;
    }
}
