import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    public Button accessClientButton;
    public Button accessEmpleatButton;
    public Label messageBox;
    public TextField dniTextInput;

    StagesManager sl = new StagesManager();
    GestorDades g = new GestorDades();

    public void login(ActionEvent e) throws Exception {
        String dniIn = dniTextInput.getText();
        if (Utils.checkDNI(dniIn)){
            if (e.getSource() == accessClientButton){
                Client c = g.getClientByDni(dniIn);
                if (c == null){
                    messageBox.setText("DNI de Person.Client invalid");
                    messageBox.setVisible(true);
                }else {
                    sl.mainStage(e,"/stages/principal.fxml","Aeroreserves");
                }
            }
        }else {
            messageBox.setText("Format de DNI incorrecte");
            messageBox.setVisible(true);
        }
    }
}
