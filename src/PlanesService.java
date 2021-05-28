import java.sql.*;
import java.util.ArrayList;

public class PlanesService {
    Connection c = new Connection();
    public void getAllPlanes(){
        c.getConnection();
        ArrayList<Plane> listPlane = new ArrayList<>();
        try {
            Statement stmt = c.getConnection().createStatement();
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
        };
    }
}
