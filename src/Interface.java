public class Interface {

    public static void mostrarMenu(String[] menu) {
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }
    public static void menuConsultes() {
        String[] menuConsultes = {
                "CONSULTES",
                "1-Obtenir avions",
                "2-Obtenir models",
                "3-Obtenir reserves",
                "4-Obtenir clients",
                "5-Tornar al menú"
        };
        for (int i = 0; i < menuConsultes.length; i++) {
            System.out.println(menuConsultes[i]);
        }
    }

    public static void menuAfegir() {
        String[] menuAfegir = {
                "¿Que vols afegir?",
                "1-Clients",
                "2-Empleats",
                "3-Models",
                "4-Avions",
                "5-Reserves"

        };
        for (int i = 0; i < menuAfegir.length; i++) {
            System.out.println(menuAfegir[i]);
        }
    }
    public static void menuEsborrar(){
        String[] menuEsborrar = {
                "¿Que vols esborrar?",
                "1-Clients",
                "2-Empleats",
                "3-Models",
                "4-Avions",
                "5-Reserves"

        };
        for (int i = 0; i < menuEsborrar.length; i++) {
            System.out.println(menuEsborrar[i]);
        }
    }
}