
import java.util.Scanner;

public class ProjectePOO {
     public static void main(String[] args) {

         Scanner in = new Scanner(System.in);
         String[] menu = {
                 "MENÚ",
                 "1-Carregar dades",
                 "2-Consultar",
                 "3-Afegir",
                 "4-Esborrar",
                 "0-Sortir",
         };
         int opcio ;
         GestorDades g = new GestorDades();
         do {
             opcio = in.nextInt();
             Interface.mostrarMenu(menu,opcio);
             switch(opcio) {
                 case 1: g.;break;
                 case 2: g.;break;
                 case 3: g.;break;
                 case 4: g.;break;
                 case 0: break;
             }
         } while (opcio!=0);
     }
}