import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

public class GestorDades {
    PlanesService p = new PlanesService();
    ModelsService m = new ModelsService();
    ReservationService r = new ReservationService();
    ClientsService c = new ClientsService();
    java.sql.Connection  conn;

    public void startConnection() throws SQLException {
       conn = Connection.openConnection();
    }

    public void getAllModels(){
        try {
            ArrayList<Model> listModel = m.getAllModels(conn);
            for (Model m :listModel) {
                System.out.println(m);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllPlanes(){
        try {
            ArrayList<Plane> listPlane = p.getAllPlanes(conn);
            for (Plane p :listPlane) {
                System.out.println(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllReservations(){
        try {
            ArrayList<Reservation> listReservation = r.getAllReservations(conn);
            for (Reservation r :listReservation) {
                System.out.println(r);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void getAllClients(){
        try {
            ArrayList<Client> listClient = c.getAllClients(conn);
            for (Client c :listClient) {
                System.out.println(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertClientsInfo() throws SQLException {
        ClientsService c = new ClientsService();
        Scanner in = new Scanner(System.in);
        String dni;
        String name;
        String surname1;
        String surname2;
        String licence;
        System.out.println("Introdueix el DNI del client");
        dni = in.next();
        System.out.println("Introdueix el nom del client");
        name = in.next();
        System.out.println("Introdueix el primer cognom del client");
        surname1 = in.next();
        System.out.println("Introdueix el segon cognom del client");
        surname2 = in.next();
        System.out.println("Introdueix la licencia del client");
        licence = in.next();
        boolean correcto = true;
        if (dni.length() == 9 && name.length() <= 45 && surname1.length() <= 45 && surname2.length() <= 45 && licence.length() <= 4){
                if (Utils.checkDNI(dni)){
                } else {
                    correcto = false;
                }
            if (correcto){
                c.insertClients(dni,name,surname1,surname2,licence,conn);
            } else
                System.out.println("Los datos son incorrectos");
        }
    }
}