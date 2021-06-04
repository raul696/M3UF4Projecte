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
    /**
     * Per comprovar si el DNI está en un format correcte
     * @param dni
     * @return
     */
    static boolean checkDNI(String dni) {
        return dni.matches("\\d{8}[A-Z]$");
    }
}