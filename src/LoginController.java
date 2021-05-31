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
                Client client = g.getClientByDni(dniIn);
                if (client == null){
                    messageBox.setText("DNI de Client invalid");
                    messageBox.setVisible(true);
                }else {
                    sl.mainStage(e,"/stages/principal.fxml","Aeroreserves");
                }
            }else {
                Employee employee = g.getEmployeeByDni(dniIn);
                if (employee == null){
                    messageBox.setText("DNI d'Empleat invalid");
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
