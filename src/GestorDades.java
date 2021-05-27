import java.sql.*;

public class GestorDades {
    public void consultarDades() {
        String jdbcURL = "jdbc:mysql://aeroalquiler.capu5jkerfks.us-east-1.rds.amazonaws.com:3306/db_aeroalquiler?serverTimezone=UTC";
        String user = "admin";
        String password = "Passw0rd";
        int batchSize = 20;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM planes");
            while(rs.next()){
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+ rs.getString(5));
            }
            connection.close();
        } catch(Exception e){
            System.out.println(e);}
    }
}
