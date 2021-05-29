public class Utils {
        public static boolean checkDNI(String dni){
            return dni.matches("\\d{8}[A-Z]$");
        }
    }