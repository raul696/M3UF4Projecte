import java.sql.*;
import java.util.ArrayList;

public class PlanesService {
    public Connection connection;
    public void openConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://aeroalquiler.capu5jkerfks.us-east-1.rds.amazonaws.com:3306/db_aeroalquiler?serverTimezone=UTC";
        String user = "admin";
        String password = "Passw0rd";
        this.connection = DriverManager.getConnection(jdbcURL, user, password);
    }
    public void closeConnection() throws SQLException {
        this.connection.close();
    }
    public ArrayList<Client> getAllClients() {
        ArrayList<Client> listClient = new ArrayList<>();
        try {
            Statement stmt= connection.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM clients");
            while(rs.next()){
                Client c =new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                listClient.add(c);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        return listClient;
    }
    public ArrayList<Plane> getAllPlanes() {
        ArrayList<Plane> listPlane = new ArrayList<>();
        try {
            Statement stmt= connection.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM planes");
            while(rs.next()){
                Plane p =new Plane(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                listPlane.add(p);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        return listPlane;
    }
}
