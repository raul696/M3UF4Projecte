import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    public static java.sql.Connection openConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://aeroalquiler.capu5jkerfks.us-east-1.rds.amazonaws.com:3306/db_aeroalquiler?serverTimezone=UTC";
        String user = "admin";
        String password = "Passw0rd";
        return DriverManager.getConnection(jdbcURL, user, password);
    }
}
