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

    public void getAllModels() {
        try {
            ArrayList<Model> listModel = m.getAllModels(conn);
            for (Model m : listModel) {
                System.out.println(m);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllPlanes() {
        try {
            ArrayList<Plane> listPlane = p.getAllPlanes(conn);
            for (Plane p : listPlane) {
                System.out.println(p);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllReservations() {
        try {
            ArrayList<Reservation> listReservation = r.getAllReservations(conn);
            for (Reservation r : listReservation) {
                System.out.println(r);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllClients() {
        try {
            ArrayList<Client> listClient = c.getAllClients(conn);
            for (Client c : listClient) {
                System.out.println(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertClientsInfo() throws SQLException {
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

    public void insertPlanesInfo() throws SQLException {
        Scanner in = new Scanner(System.in);
        String registrationCode;
        String model;
        String mainColor;
        int hoursFlied;
        System.out.println("Introdueix el codi de l'avió");
        registrationCode = in.next();
        System.out.println("Introdueix el model de l'avió");
        model = in.next();
        System.out.println("Introdueix el color principal de l'avió");
        mainColor = in.next();
        System.out.println("Introdueix les hores volades de l'avió");
        hoursFlied = in.nextInt();
        if (registrationCode.length() <= 10 && model.length() <= 35 && mainColor.length() <= 15) {
            p.insertPlane( registrationCode, model, mainColor, hoursFlied, conn);
        } else {
            System.out.println("Les dades son incorrectes ");
        }
    }

    public void insertModelsInfo() throws SQLException {
        Scanner in = new Scanner(System.in);
        String modelName;
        String brand;
        short pax;
        String licenceType;
        float fuelCapacity;
        short maxSpeed;
        int consumPerHour;
        int maxTakeoffWeight;
        int emptyWeight;

        System.out.println("Introdueix el nom del model");
        modelName = in.next();
        System.out.println("Introdueix la marca de l'avió");
        brand = in.next();
        System.out.println("Introdueix la capacitat de seients de l'avió");
        pax = in.nextShort();
        System.out.println("Introdueix el tipus de licencia");
        licenceType = in.next();
        System.out.println("Introdueix la capacitat màxima de litres de gasoil");
        fuelCapacity = in.nextFloat();
        System.out.println("Introdueix la velocitat màxima de l'avió");
        maxSpeed = in.nextShort();
        System.out.println("Introdueix el consum per hora de gasoil");
        consumPerHour = in.nextInt();
        System.out.println("Introdueix el pes màxim de l'avió");
        maxTakeoffWeight = in.nextInt();
        System.out.println("Introdueix el pes de l'avió buit");
        emptyWeight = in.nextInt();
        if (modelName.length() <= 35 && brand.length() <= 25 && licenceType.length() <= 15) {
            m.insertarModels( modelName, brand, pax, licenceType, fuelCapacity, maxSpeed, consumPerHour, maxTakeoffWeight, emptyWeight, conn);
        } else {
            System.out.println("Les dades son incorrectes ");
        }
    }

    public void insertEmployeesInfo() throws SQLException {
        Scanner in = new Scanner(System.in);
        String dni;
        String name;
        String surname1;
        String surname2;
        System.out.println("Introdueix el DNI del empleat");
        dni = in.next();
        System.out.println("Introdueix el nom del empleat");
        name = in.next();
        System.out.println("Introdueix el primer cognom del empleat");
        surname1 = in.next();
        System.out.println("Introdueix el segon cognom del empleat");
        surname2 = in.next();
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

    public void insertReservationsInfo() throws SQLException {
        Scanner in = new Scanner(System.in);
        int clientId;
        int planeId;
        Timestamp startDate;
        Timestamp endDate;
        System.out.println("Introdueix la ID del client");
        clientId = in.nextInt();
        System.out.println("Introdueix la ID de l'avió");
        planeId = in.nextInt();
        System.out.println("Introdueix la data de recollida (YYYY-MM-DD 00:00)");
        startDate = Timestamp.valueOf(in.next());
        System.out.println("Introdueix la data de entrega (YYYY-MM-DD 00:00)");
        endDate = Timestamp.valueOf(in.next());
        boolean correcto = true;
        if (correcto) {
            r.insertReservation( clientId, planeId, startDate, endDate, conn);
        } else
            System.out.println("Les dades son incorrectes");
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
}