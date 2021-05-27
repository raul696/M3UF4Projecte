public class Interface {

    public static void mostrarMenu(String[] menu){
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }

    public static void menuConsultes(){
        String[] menu = {
                "CONSULTES",
                "1-Obtenir avions",
                "2-Obtenir models",
                "3-Obtenir reserves",
        };
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }
}