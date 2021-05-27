
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
         int opcio = in.nextInt();
         GestorDades g = new GestorDades();
         do {
             Interface.mostrarMenu(menu,opcio);
             switch(opcio) {
                 case 1: ;break;
                 case 2: ;break;
                 case 3: ;break;
                 case 4: ;break;
                 case 0: break;
             }
             opcio = in.nextInt();
         } while (opcio!=0);
     }
}