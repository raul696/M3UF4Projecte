import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    StagesManager sl = new StagesManager();
    GestorDades g = new GestorDades();

    @Override
    public void start(Stage primaryStage) throws Exception{
        g.startConnection();
        sl.loginStage();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
