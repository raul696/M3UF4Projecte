import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StagesManager {
    Stage stage = new Stage();

    public void loginStage() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/stages/inici.fxml"));
        stage.setTitle("Login");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    public void closeStage(){
        stage.close();
    }

    public void changeStage(javafx.event.ActionEvent event ,String fxml, String title) throws Exception{
        //Parent page = FXMLLoader.load(getClass().getResource("../stages/principal.fxml"));
        Parent page = (Parent) FXMLLoader.load(getClass().getResource(fxml), null, new JavaFXBuilderFactory());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(page);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        }
}
