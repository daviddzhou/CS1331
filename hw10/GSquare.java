
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
// Welcome to javafx, the land of imports :p
import javafx.scene.control.TextInputDialog;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * The main driver for the GSquare application. Support classes not included.
 *
 * @author 1331 TA's
 * @version 1.0
 */
public class GSquare extends Application {
    private GSquareGradebook grades = new GSquareGradebook();

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        // Student Table
        TableView<Student> studentTable = createStudentTable();
        studentTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Control Pane
        HBox control = new HBox();

        Button studentButton = new Button("New Student");
        studentButton.setOnAction(e -> {
                TextInputDialog prompt = new TextInputDialog();
                prompt.setContentText("Enter name for the new Student");
                prompt.showAndWait()
                    .ifPresent(response -> {
                            grades.addStudent(response, 100, 100);
                            studentTable.getItems().clear();
                            studentTable.getItems()
                                .addAll(grades.getStudents());
                        });
            });

        Button changeTestGrade = new Button("Change Test Grade");
        changeTestGrade.setOnAction(e -> {
                Student selected = studentTable.getSelectionModel()
                    .getSelectedItem();
                if (selected != null) {
                    TextInputDialog prompt = new TextInputDialog();
                    prompt.setContentText("Enter a new test grade");
                    prompt.showAndWait()
                        .ifPresent(response -> {
                                grades.setTestGrade(selected.getName(),
                                        Integer.valueOf(response));
                                studentTable.getItems().clear();
                                studentTable.getItems().addAll(
                                        grades.getStudents());
                            });
                } else {
                    new Alert(Alert.AlertType.ERROR,
                            "Please Select a student").showAndWait();
                }
            });

        Button changeHomeworkGrade = new Button("Change Homework Grade");
        changeHomeworkGrade.setOnAction(e -> {
                Student selected =
                    studentTable.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    TextInputDialog prompt = new TextInputDialog();
                    prompt.setContentText("Enter a new homework grade");
                    prompt.showAndWait()
                        .ifPresent(response -> {
                                grades.setHomeworkGrade(selected.getName(),
                                        Integer.valueOf(response));
                                studentTable.getItems().clear();
                                studentTable.getItems().addAll(
                                        grades.getStudents());
                            });
                } else {
                    new Alert(Alert.AlertType.ERROR,
                            "Please Select a student").showAndWait();
                }
            });

        control.getChildren().addAll(studentButton, changeTestGrade,
                changeHomeworkGrade);

        // Setup window
        root.setTop(control);
        root.setCenter(studentTable);
        Scene main = new Scene(root, 800, 400);
        stage.setScene(main);
        stage.setTitle("GSquare");
        stage.show();
    }

    private TableView<Student> createStudentTable() {

        // Setup table
        TableView<Student> table = new TableView<Student>();

        // Create table columns
        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Student, String>("name"));
        TableColumn<Student, Integer> testCol =
            new TableColumn<>("Test Grade");
        testCol.setCellValueFactory(new
                PropertyValueFactory<Student, Integer>("testGrade"));
        TableColumn<Student, Integer> homeworkCol =
            new TableColumn<>("Homework Grade");
        homeworkCol.setCellValueFactory(new
                PropertyValueFactory<Student, Integer>("homeworkGrade"));


        table.getColumns().setAll(nameCol, testCol, homeworkCol);
        return table;
    }
}
