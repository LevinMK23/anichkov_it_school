import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(
                FXMLLoader.load(getClass().getResource("calculator.fxml"))
        ));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
