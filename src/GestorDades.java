import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;
import java.util.ArrayList;

public class GestorDades {
    PlanesService p = new PlanesService();
    ModelsService m = new ModelsService();
    ReservationService r = new ReservationService();
    ClientsService c = new ClientsService();
    EmployeeService e = new EmployeeService();
    java.sql.Connection conn;

    public void startConnection() throws SQLException {
        conn = Connection.openConnection();
    }

    public ArrayList<Model> getAllModels() {
        try {
            ArrayList<Model> listModel = m.getAllModels(conn);
            return listModel;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<Plane> getAllPlanes() {
        try {
            ArrayList<Plane> listPlane = p.getAllPlanes(conn);
            return listPlane;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<Reservation> getAllReservations() {
        try {
            ArrayList<Reservation> listReservation = r.getAllReservations(conn);
            return listReservation;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<Client> getAllClients() {
        try {
            ArrayList<Client> listClient = c.getAllClients(conn);
            return listClient;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void insertClientsInfo(String dni, String name, String surname1, String surname2, String licence) throws SQLException {
        boolean correcto = true;
        if (name.length() <= 45 && surname1.length() <= 45 && surname2.length() <= 45 && licence.length() <= 4) {
            if (Utils.checkDNI(dni)) {
            } else {
                correcto = false;
            }
            if (correcto) {
                c.insertClients(dni, name, surname1, surname2, licence, conn);
            } else
                System.out.println("Les dades son incorrectes");
        }
    }

    public void insertPlanesInfo(String registrationCode, String model, String mainColor, int hoursFlied) throws SQLException {
        if (registrationCode.length() <= 10 && model.length() <= 35 && mainColor.length() <= 15) {
            p.insertPlane( registrationCode, model, mainColor, hoursFlied, conn);
        } else {
            System.out.println("Les dades son incorrectes ");
        }
    }

    public void insertModelsInfo(String modelName,String brand,short pax, String licenceType,float fuelCapacity,short maxSpeed,int consumPerHour,int maxTakeoffWeight,int emptyWeight) throws SQLException {
        if (modelName.length() <= 35 && brand.length() <= 25 && licenceType.length() <= 15) {
            m.insertarModels( modelName, brand, pax, licenceType, fuelCapacity, maxSpeed, consumPerHour, maxTakeoffWeight, emptyWeight, conn);
        } else {
            System.out.println("Les dades son incorrectes ");
        }
    }

    public void insertEmployeesInfo(String dni, String name, String surname1, String surname2) throws SQLException {
        boolean correcto = true;
        if (name.length() <= 45 && surname1.length() <= 45 && surname2.length() <= 45) {
            if (Utils.checkDNI(dni)) {
            } else {
                correcto = false;
            }
            if (correcto) {
                e.insertEmployees(dni, name, surname1, surname2, conn);
            } else
                System.out.println("Les dades son incorrectes");
        }
    }

    public void insertReservationsInfo(int clientId,int planeId, Timestamp startDate, Timestamp endDate) throws SQLException {
            r.insertReservation( clientId, planeId, startDate, endDate, conn);
    }
    public void deleteClient() throws SQLException{
        Scanner in = new Scanner(System.in);
        String dni;
        System.out.println("Introdueix el DNI del client");
        dni = in.next();
        boolean correcto = true;
        if (Utils.checkDNI(dni)) {
            } else {
                correcto = false;
            }
            if (correcto) {
                c.deleteClient(dni, conn);
            } else
                System.out.println("Les dades son incorrectes");
    }
    public void deleteEmpleat() throws SQLException{
        Scanner in = new Scanner(System.in);
        String dni;
        System.out.println("Introdueix el DNI del client");
        dni = in.next();
        boolean correcto = true;
        if (Utils.checkDNI(dni)) {
        } else {
            correcto = false;
        }
        if (correcto) {
            c.deleteClient(dni, conn);
        } else
            System.out.println("Les dades son incorrectes");
    }
}