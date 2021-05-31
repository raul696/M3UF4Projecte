import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class FunctionTEST {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        String[] menu = {
                "MENÚ",
                "1-Consultar",
                "2-Afegir",
                "3-Esborrar",
                "0-Sortir",
        };
        GestorDades g = new GestorDades();
        g.startConnection();
        int opcio = 0;
        int opcio2=0;
        do {
            Interface.mostrarMenu(menu);
            opcio = in.nextInt();
            switch (opcio) {
                case 1:
                    System.out.println();
                    Interface.menuConsultes();
                    opcio2= in.nextInt();
                    if(opcio2==1){
                        g.getAllPlanes();
                    }else if(opcio2==2){
                       g.getAllModels();
                    }else if(opcio2==3){
                        g.getAllReservations();
                    } else if (opcio2==4){
                        g.getAllClients();
                    } else if (opcio2==5){
                        g.getAllEmployees();
                    }
                    break;
                case 2:
                    System.out.println();
                    Interface.menuAfegir();
                    opcio2 = in.nextInt();
                    if (opcio2 == 1){
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
                        g.insertClientsInfo(dni,name,surname1,surname2,licence);
                    }else if(opcio2==2){
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
                        g.insertEmployeesInfo(dni,name,surname1,surname2);
                    }else if(opcio2==3){
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
                        g.insertModelsInfo(modelName,brand,pax,licenceType,fuelCapacity,maxSpeed,consumPerHour,maxTakeoffWeight,emptyWeight);
                    }else if(opcio2==4){
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
                        g.insertPlanesInfo(registrationCode,model,mainColor,hoursFlied);
                    }else if (opcio2==5){
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
                        g.insertReservationsInfo(clientId,planeId,startDate,endDate);
                    }
                    break;
                case 3:
                    System.out.println();
                    Interface.menuEsborrar();
                    opcio2 = in.nextInt();
                    if (opcio2 == 1){
                        String dni;
                        System.out.println("Introdueix el DNI del client");
                        dni = in.next();
                        g.deleteClient(dni);
                    }else if(opcio2==2){
                        String dni;
                        System.out.println("Introdueix el DNI del empleat");
                        dni = in.next();
                        g.deleteEmpleat(dni);
                    }else if(opcio2==3){
                        String modelName;
                        System.out.println("Introdueix el nom del model");
                        modelName = in.next();
                        g.deleteModel(modelName);
                    }else if(opcio2==4){
                        String registrationCode;
                        System.out.println("Introdueix el codi de l'avió");
                        registrationCode = in.next();
                        g.deletePlane(registrationCode);
                    }else if (opcio2==5){

                    }
                    break;
                case 0:
                    Connection.openConnection().close();
                    break;

                default:
                    System.out.println("Nomes nombres del 0 al 3");
            }
        }while (opcio != 0) ;
    }
}