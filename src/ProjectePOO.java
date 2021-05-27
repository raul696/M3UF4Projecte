
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
        Interface i = new Interface();
        GestorDades g = new GestorDades();

        int opcio = 0;
        do {
            i.mostrarMenu(menu);
            opcio = in.nextInt();
            switch (opcio) {
                case 1:
                    System.out.println();
                    g.consultarDades();

                    break;
                case 2:
                    System.out.println();
                    i.menuConsultes();
                    break;
                case 3:
                    System.out.println();
                    i.menuAfegir();
                    break;
                case 4:
                    System.out.println();
                    i.menuEsborrar();
                    break;
                case 0:
                    break;

                default:
                    System.out.println("Nomes nombres del 0 al 4");
            }
        }while (opcio != 0) ;
    }
}