import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Menu opcioMenuClients;
    public BorderPane mainPane;
    public MenuItem clientsView;
    public MenuItem empleatsView;
    public MenuItem reservesView;
    public MenuItem avionsView;
    // View Perfil
    public Label nomCompletLabel;
    public Label dniLabel;
    // View Clients
    public Button showAllClients;
    public TableView<Client> clientsTable;
    public TableColumn<Client, Integer> idClientCol;
    public TableColumn<Client, String> dniClientCol;
    public TableColumn<Client, String> nomClientCol;
    public TableColumn<Client, String> cognom1ClientCol;
    public TableColumn<Client, String> cognom2ClientCol;
    public TableColumn<Client, String> llicenciaClientCol;
    // View Empleats
    public TableView<Employee> empleatsTable;
    public TableColumn<Employee, Integer> idEmpleatCol;
    public TableColumn<Employee, String> dniEmpleatCol;
    public TableColumn<Employee, String> nomEmpleatCol;
    public TableColumn<Employee, String> cognom1EmpleatCol;
    public TableColumn<Employee, String> cognom2EmpleatCol;
    // View Reserves
    public TableView<Reservation> reservesTable;
    public TableColumn<Reservation, Integer> idReservaCol;
    public TableColumn<Reservation, String> idClientReservaCol;
    public TableColumn<Reservation, Integer> idAvioReservaCol;
    public TableColumn<Reservation, Timestamp> dataIniciReservaCol;
    public TableColumn<Reservation, Timestamp> dataFiReservaCol;
    // Reserves insert
    public TextField idClientReservaIns;
    public TextField idAvioReservaIns;
    public TextField dataIniciReservaIns;
    public TextField horaIniciReservaIns;
    public TextField dataFiReservaIns;
    public TextField horaFiReservaIns;
    public Label reservesErrorBox;
    // View Avions
    public Button showAllPlanes;
    public TableView<Plane> avionsTable;
    public TableColumn<Plane, Integer> idAvioCol;
    public TableColumn<Plane, String> codiRegistreCol;
    public TableColumn<Plane, String> modelCol;
    public TableColumn<Plane, String> mainColorCol;
    public TableColumn<Plane, Timestamp> horesVolCol;

    StagesManager sl = new StagesManager();
    GestorDades g = new GestorDades();

    private void setCurrentUserInfo(Person c) throws InterruptedException {
        System.out.println(nomCompletLabel.getText());
        nomCompletLabel.setText(c.getName()+" "+c.getSurname1()+" "+c.getSurname2());
        dniLabel.setText(c.getDni());
    }

    public void showAllPlanes(){
        initializePlanesTable();
        ObservableList<Plane> planeData = FXCollections.observableArrayList();
        ArrayList<Plane> planeList = g.getAllPlanes();
        planeData.addAll(planeList);
        avionsTable.setItems(planeData);
    }

    public void showAllClients(){
        initializeClientsTable();
        ObservableList<Client> clientData = FXCollections.observableArrayList();
        ArrayList<Client> clientList = g.getAllClients();
        clientData.addAll(clientList);
        clientsTable.setItems(clientData);
    }

    public void showAllEmployee(){
        initializeEmpleatsTable();
        ObservableList<Employee> employeeData = FXCollections.observableArrayList();
        ArrayList<Employee> employeeList = g.getAllEmployees();
        employeeData.addAll(employeeList);
        empleatsTable.setItems(employeeData);
    }

    public void showAllReservations(){
        initializeReservesTable();
        ObservableList<Reservation> reservationsData = FXCollections.observableArrayList();
        ArrayList<Reservation> reservationsList = g.getAllReservations();
        reservationsData.addAll(reservationsList);
        reservesTable.setItems(reservationsData);
    }

    public void insertReservation(){
        try{
            int clientId = Integer.parseInt(idClientReservaIns.getText());
            int planeId = Integer.parseInt(idAvioReservaIns.getText());
            Timestamp dataInici = Timestamp.valueOf(dataIniciReservaIns.getText() + " " + horaIniciReservaIns.getText()+":00.0");
            Timestamp dataFi = Timestamp.valueOf(dataFiReservaIns.getText() + " " + horaFiReservaIns.getText()+":00.0");
            try {
                g.insertReservationsInfo(clientId, planeId, dataInici, dataFi);
                reservesErrorBox.setText("Reserva afegida correctament");
                reservesErrorBox.setStyle("-fx-background-color: #81F79F;");
                reservesErrorBox.setVisible(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                reservesErrorBox.setText("El insert ha fallat, comprova que les dades son correctes");
                reservesErrorBox.setStyle("-fx-background-color: #ff9696;");
                reservesErrorBox.setVisible(true);
            }
        }catch (Exception e){
            reservesErrorBox.setText("El format de dades no es correcte");
            reservesErrorBox.setStyle("-fx-background-color: #ff9696;");
            reservesErrorBox.setVisible(true);
        }
    }

    public void changeView(ActionEvent e) throws Exception {
        Object source = e.getSource();
        if (source == clientsView){
            sl.changeMainView(mainPane, "/stages/clientsView.fxml");
        }else if (source == empleatsView){
            sl.changeMainView(mainPane, "/stages/empleatsView.fxml");
        }else if (source == avionsView){
            sl.changeMainView(mainPane, "/stages/avionsView.fxml");
        }else if (source == reservesView){
            sl.changeMainView(mainPane, "/stages/reservationsView.fxml");
        }
    }

    public void initializePlanesTable(){
        idAvioCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        codiRegistreCol.setCellValueFactory(new PropertyValueFactory<>("registrationCode"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        mainColorCol.setCellValueFactory(new PropertyValueFactory<>("mainColor"));
        horesVolCol.setCellValueFactory(new PropertyValueFactory<>("hoursFlied"));
    }

    public void initializeClientsTable(){
        idClientCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        dniClientCol.setCellValueFactory(new PropertyValueFactory<>("dni"));
        nomClientCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cognom1ClientCol.setCellValueFactory(new PropertyValueFactory<>("surname1"));
        cognom2ClientCol.setCellValueFactory(new PropertyValueFactory<>("surname2"));
        llicenciaClientCol.setCellValueFactory(new PropertyValueFactory<>("licence"));
    }

    public void initializeEmpleatsTable(){
        idEmpleatCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        dniEmpleatCol.setCellValueFactory(new PropertyValueFactory<>("dni"));
        nomEmpleatCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cognom1EmpleatCol.setCellValueFactory(new PropertyValueFactory<>("surname1"));
        cognom2EmpleatCol.setCellValueFactory(new PropertyValueFactory<>("surname2"));
    }

    public void initializeReservesTable(){
        idReservaCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idClientReservaCol.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        idAvioReservaCol.setCellValueFactory(new PropertyValueFactory<>("planeId"));
        dataIniciReservaCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        dataFiReservaCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
