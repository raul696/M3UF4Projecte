import java.sql.*;
import java.time.LocalDateTime;
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
    public ArrayList<Plane> getPlaneByModel(Connection conn,String model) throws SQLException{
        ArrayList<Plane> listPlane = new ArrayList<>();
        try {

            String query  = " SELECT * FROM planes p" +
                    " INNER JOIN reservations r ON p.plane_id = r.plane_id" +
                    " WHERE p.model = ? AND p.plane_id IN (SELECT r.plane_id" +
                    " FROM reservations r"+
                    " WHERE ? NOT BETWEEN r.start_date and r.end_date);" ;

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,model);
            stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));

            ResultSet rs = stmt.executeQuery(String.valueOf(stmt));

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

            String query = "INSERT INTO planes ( registrationCode, model, mainColor, hoursFlied) " +
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