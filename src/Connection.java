import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connection {

    /**
     * Funció que obre la connexió amb la base de dades, es crida només una vegada al inici del programa
     * @return Retorna la connexió
     * @throws SQLException
     */
    public static java.sql.Connection openConnection() throws SQLException {
        Properties prop = new Properties();
        try {
            FileInputStream ip= new FileInputStream("config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jdbcURL = prop.getProperty("DB_LINK");
        String user = prop.getProperty("DB_USER");
        String password = prop.getProperty("DB_PASSWORD");
        return DriverManager.getConnection(jdbcURL, user, password);
    }

}
