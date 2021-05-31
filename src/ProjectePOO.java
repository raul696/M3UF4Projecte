
import java.sql.SQLException;
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
                        g.insertClientsInfo();
                    }else if(opcio2==2){
                        g.insertEmployeesInfo();
                    }else if(opcio2==3){
                        g.insertModelsInfo();
                    }else if(opcio2==4){
                        g.insertPlanesInfo();
                    }else if (opcio2==5){
                        g.insertReservationsInfo();
                    }
                    break;
                case 3:
                    System.out.println();
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