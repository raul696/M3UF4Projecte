import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;

public class PlanesService {

    public ArrayList<Plane> getAllPlanes(Connection conn) throws SQLException{
        ArrayList<Plane> listPlane = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM planes");
            while (rs.next()) {
                Plane p = new Plane(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                listPlane.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (Plane p :listPlane
             ) {
            System.out.println(p);
        }
        return listPlane;
    }
    public void insertPlane(String registrationCode, String model, String mainColor, int hoursFlied, Connection conn) {
        try {

            String query = "INSERT INTO planes ( registration_code, model, main_color, hours_flied) " +
                    "VALUES ( ?,?,?,?)" ;


            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,registrationCode);
            stmt.setString(2,model);
            stmt.setString(3,mainColor);
            stmt.setInt(4,hoursFlied);

            stmt.execute();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void deletePlane(String registrationCode, Connection conn){
        try {

            String query = "DELETE FROM planes" + " WHERE registration_code = ?" ;


            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,registrationCode);

            stmt.execute();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}