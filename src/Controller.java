import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {
    public Button accessClientButton;
    public Button accessEmpleatButton;
    public Label messageBox;
    public TextField dniTextInput;

    StagesManager sl = new StagesManager();
    public void login(ActionEvent e) throws Exception {
        if (Utils.checkDNI(dniTextInput.getText())){
            sl.changeStage(e,"/stages/principal.fxml","Aeroreserves");
        }else {
            messageBox.setText("Format de DNI incorrecte");
            messageBox.setVisible(true);
        }
    }
}
