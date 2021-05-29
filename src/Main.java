import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    StagesManager sl = new StagesManager();

    @Override
    public void start(Stage primaryStage) throws Exception{
        sl.loginStage();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
