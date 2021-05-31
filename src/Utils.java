public class Utils implements check {
    public static boolean checkDNI(String dni){return dni.matches("\\d{8}[A-Z]$"); }
}
interface check{
    static boolean checkDNI(String dni) {
        return dni.matches("\\d{8}[A-Z]$");
    }
}