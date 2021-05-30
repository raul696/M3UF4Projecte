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
    public void insertPlane(Integer id, String registrationCode, String model, String mainColor, int hoursFlied, Connection conn) {
        try {

            String query = "INSERT INTO planes (id, registrationCode, model, mainColor, hoursFlied) " +
                    "VALUES ( ?,?,?,?,?)" ;


            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,id);
            stmt.setString(2,registrationCode);
            stmt.setString(3,model);
            stmt.setString(4,mainColor);
            stmt.setInt(5,hoursFlied);

            stmt.execute();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}