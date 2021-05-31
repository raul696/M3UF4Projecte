
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class ProjectePOO {
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
        int opcio = 0;
        int opcio2=0;
        g.startConnection();
        String dni;
        String name;
        String surname1;
        String surname2;
        String licence;
        int clientId;
        int planeId;
        Timestamp startDate;
        Timestamp endDate;
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
                    }
                    break;
                case 2:
                    System.out.println();
                    Interface.menuAfegir();
                    opcio2 = in.nextInt();
                    if (opcio2 == 1){
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
                        g.insertEmployeesInfo();
                    }else if(opcio2==3){
                        g.insertModelsInfo();
                    }else if(opcio2==4){
                        g.insertPlanesInfo();
                    }else if (opcio2==5){
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
                    /*System.out.println();
                    Interface.menuEsborrar();
                    opcio2 = in.nextInt();
                    if (opcio2 == 1){
                        g.deleteClient();
                    }else if(opcio2==2){
                        g.insertEmployeesInfo();
                    }else if(opcio2==3){
                        g.insertModelsInfo();
                    }else if(opcio2==4){
                        g.insertPlanesInfo();
                    }else if (opcio2==5){
                        g.insertReservationsInfo();
                    }*/
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