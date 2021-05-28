
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
        PlanesService p = new PlanesService();
        ModelsService m = new ModelsService();
        ReservationService r = new ReservationService();
        int opcio = 0;
        int opcio2=0;
        p.openConnection();
        do {
            Interface.mostrarMenu(menu);
            opcio = in.nextInt();
            switch (opcio) {
                case 1:
                    System.out.println();
                    Interface.menuConsultes();
                    opcio2= in.nextInt();
                    if(opcio2==1){
                        p.getAllPlanes();
                    }else if(opcio2==2){
                       m.getAllModels();
                    }else if(opcio2==3){
                        r.getAllReservations();
                    }
                    break;
                case 2:
                    System.out.println();
                    Interface.menuAfegir();
                    break;
                case 3:
                    System.out.println();
                    Interface.menuEsborrar();
                    break;
                case 0:
                    p.closeConnection();
                    break;

                default:
                    System.out.println("Nomes nombres del 0 al 3");
            }
        }while (opcio != 0) ;
    }
}