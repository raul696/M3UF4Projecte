public class Interface {

    public static void mostrarMenu(String[] menu,int opcio){
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }

    public static void menuConsultes(){
        String[] menu = {
                "CONSULTES",
                "1-obtenir avions",
                "2-obtenir models",
                "3-obtenir reserves",
        };
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }
}