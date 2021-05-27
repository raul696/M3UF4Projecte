
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
         int opcio=0;
         Interface i = new Interface();
         GestorDades g = new GestorDades();
         do {
             i.mostrarMenu(menu);
             opcio = in.nextInt();
             switch(opcio) {
                 case 1:
                     ;
                 break;
                 case 2:
                     System.out.println();
                     i.menuConsultes();
                     break;
                 case 3:
                     ;
                 break;
                 case 4:
                     ;
                 break;
                 case 0:
                     break;
             }
             opcio = in.nextInt();
         } while (opcio!=0);
     }
}