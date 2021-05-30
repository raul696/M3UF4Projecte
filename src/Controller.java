import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.net.URL;
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
        ArrayList<Employee> employeeList = g.getAllEmployee();
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
