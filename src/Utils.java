public class Utils implements check {
    /**
     *
     * @param dni
     * @return Retorna true si el format del DNI es correcte i false en cas contrari
     */
    public static boolean checkDNI(String dni){
        return dni.matches("\\d{8}[A-Z]$");
    }
}

interface check{
    static boolean checkDNI(String dni) {
        return dni.matches("\\d{8}[A-Z]$");
    }
}