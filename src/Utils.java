public class Utils implements check {
    public static boolean checkDNI(String dni){return dni.matches("\\d{8}[A-Z]$"); }
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