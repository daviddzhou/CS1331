import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
/**
*This class is the container for creation of GUI and launching of applet
*@author David Zhou
*@version 1.123
*/
public class Slot extends Application {

    private Stage window;
    private int money = 100;
    private int reward;
    private int pay;
    private Integer bet;
    private Button button;
    private RadioButton regular;
    private RadioButton test;
    private ToggleGroup tog;
    private GridPane grid = new GridPane();
    private GridPane grid1 = new GridPane();
    private GridPane grid2 = new GridPane();
    private BorderPane border = new BorderPane();
    private StackPane stack = new StackPane();
    private StackPane stackBack = new StackPane();
    private Label input2;
    private Label currentMoney;
    private TextField input;
    private ImageView question;
    private ImageView question2;
    private ImageView question3;
    private ImageView side;
    private ImageView side1;
    private ImageView head;
    private ImageView back1;
    private ImageView back2;
    private Image q1;
    private Image q2;
    private Image q3;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Slot Machine v1.0!");

        Scene scene = new Scene(getStackPane(), 900, 660);
        window.setScene(scene);

        window.show();

        button.setOnAction(e -> {
                if (input.getText().length() == 0) {
                    bet = 1;
                } else {
                    bet = Integer.valueOf(input.getText());
                }

                if ((bet > money) && (money != 0)) {
                    input2.setText("Cannot bet this.");
                } else if ((bet > money) && (money == 0)) {
                    input2.setText("Oops. No money!");
                } else {
                    if (tog.getSelectedToggle().equals(regular)) {
                        q1 = ImageGen.changer();
                        q2 = ImageGen.changer();
                        q3 = ImageGen.changer();
                    } else if (tog.getSelectedToggle().equals(test)) {
                        q1 = ImageGen.testChanger();
                        q2 = ImageGen.testChanger();
                        q3 = ImageGen.testChanger();
                    } else {
                        Stage popup = new Stage();
                        VBox mes = new VBox(10);
                        Label message = new Label("Please select a mode!");
                        mes.getChildren().add(message);
                        Scene pop = new Scene(mes, 50, 50);
                        popup.setScene(pop);
                        popup.show();
                    }
                    question.setImage(q1);
                    question2.setImage(q2);
                    question3.setImage(q3);
                    reward = ImageGen.winnings(q1, q2, q3);
                    if (reward != 0) {
                        pay = reward * bet;
                        money += pay;
                        currentMoney.setText("Money: " + money);
                        input2.setText("Good Spin!");
                    } else {
                        money -= bet;
                        currentMoney.setText("Money: " + money);
                        input2.setText("Unlucky.");
                    }
                    if (money == 0) {
                        input2.setText("Oops. No money!");
                    }
                }
            });
    }

    /**
    *@return returns the borderpane with formatted images
    */
    public StackPane getStackPane() {
        Image backBack = new Image("file:background.png", 900,
            660, false, false);
        back2 = new ImageView(backBack);

        Image header = new Image("file:casino.gif", 325, 125, false, false);
        head = new ImageView(header);
        grid2.setVgap(5);
        grid2.getChildren().addAll(head);
        grid2.setAlignment(Pos.CENTER);
        border.setTop(grid2);


        grid1.setPadding(new Insets(10, 10, 10, 10));
        grid1.setVgap(3);
        grid1.setHgap(10);

        Image ques = new Image("file:Question.gif", 120, 100, false, false);
        Image ques2 = new Image("file:Question.gif", 120, 100, false, false);
        Image ques3 = new Image("file:Question.gif", 120, 100, false, false);

        question = new ImageView(ques);
        question2 = new ImageView(ques2);
        question3 = new ImageView(ques3);

        GridPane.setConstraints(question, 2, 5);
        GridPane.setConstraints(question2, 3, 5);
        GridPane.setConstraints(question3, 4, 5);

        //Inner border

        HBox hBoxinner = new HBox();

        String styleinner = "-fx-border-color: black;"

            + "-fx-border-width: 1;"

            + "-fx-border-style: solid;";

        hBoxinner.setStyle(styleinner);



        //Outter border

        HBox hBoxoutter = new HBox();

        String styleoutter = "-fx-border-color: black;"

            + "-fx-border-width: 10;";

        hBoxoutter.setStyle(styleoutter);



        hBoxinner.getChildren().addAll(question, question2, question3);

        hBoxoutter.getChildren().add(hBoxinner);


        grid1.getChildren().addAll(hBoxinner);
        grid1.setAlignment(Pos.CENTER);
        Image back = new Image("file:rainbow.gif", 500, 400, false, false);
        back1 = new ImageView(back);
        stack.getChildren().addAll(back1, grid1);
        border.setCenter(stack);

        Image sidel = new Image("file:side.gif", 200, 400, false, false);
        side = new ImageView(sidel);
        border.setLeft(side);

        Image side2 = new Image("file:side.gif", 200, 400, false, false);
        side1 = new ImageView(side2);
        border.setRight(side1);

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        button = new Button();
        button.setText("Spin!");
        GridPane.setConstraints(button, 4, 7);

        regular = new RadioButton("Regular Mode");
        regular.setMinSize(RadioButton.USE_PREF_SIZE,
            RadioButton.USE_PREF_SIZE);
        GridPane.setConstraints(regular, 3, 3);
        test = new RadioButton("Test Mode");
        GridPane.setConstraints(test, 4, 3);
        tog = new ToggleGroup();
        regular.setToggleGroup(tog);
        regular.setSelected(true);
        test.setToggleGroup(tog);

        currentMoney = new Label("Money: 100");
        GridPane.setConstraints(currentMoney, 0, 3);

        input2 = new Label("Enter your bet");
        GridPane.setConstraints(input2, 0, 6);
        input = new TextField();
        GridPane.setConstraints(input, 0, 7);

        grid.getChildren().addAll(currentMoney, input2, input, button,
            regular, test);
        grid.setAlignment(Pos.CENTER);
        border.setBottom(grid);
        stackBack.getChildren().addAll(back2, border);
        return stackBack;
    }


}
