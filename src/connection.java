import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    public Connection connection;

    public void openConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://aeroalquiler.capu5jkerfks.us-east-1.rds.amazonaws.com:3306/db_aeroalquiler?serverTimezone=UTC";
        String user = "admin";
        String password = "Passw0rd";
        this.connection = DriverManager.getConnection(jdbcURL, user, password);
    }
    public Connection getConnection() {
        return connection;
    }
    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
