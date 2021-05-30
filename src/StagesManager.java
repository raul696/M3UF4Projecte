import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StagesManager {
    Stage stage = new Stage();

    public void loginStage() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/stages/inici.fxml"));
        stage.setTitle("Login");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    public void mainStage(javafx.event.ActionEvent event, String fxml, String title) throws Exception {
        //Parent page = FXMLLoader.load(getClass().getResource("../stages/principal.fxml"));
        Parent page = (Parent) FXMLLoader.load(getClass().getResource("/stages/principal.fxml"), null, new JavaFXBuilderFactory());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(page);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        BorderPane mainPane = (BorderPane) page;
        mainPane.setBottom(FXMLLoader.load(getClass().getResource("/stages/perfilView.fxml"), null, new JavaFXBuilderFactory()));

    }

    public void changeMainView(BorderPane mainPane, String viewPath) throws IOException {
        mainPane.setCenter(FXMLLoader.load(getClass().getResource(viewPath), null, new JavaFXBuilderFactory()));
    }

}
