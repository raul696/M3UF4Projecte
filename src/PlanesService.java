import java.sql.Connection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PlanesService {

    /**
     * Obté tots els avions de la base de dades
     * @param conn Connexió amb la base de dades
     * @return Retorna un ArrayList de objectes Plane
     * @throws SQLException
     */
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
            e.printStackTrace();
        }
        return listPlane;
    }

    /**
     * Obté tots els avions d'un model específic
     * @param model
     * @param conn Connexió a la base de dades
     * @return Retorna un ArrayList de objectes Plane
     */
    public ArrayList<Plane> getPlanesByModel(String model, Connection conn){
        ArrayList<Plane> listPlane = new ArrayList<>();
        try {

            String query  = "SELECT * " +
                    "FROM planes " +
                    "WHERE model = ? " +
                    "AND (plane_id NOT IN (SELECT plane_id " +
                    "FROM reservations " +
                    "WHERE ? BETWEEN start_date AND end_date) " +
                    "OR (model = ? AND plane_id NOT IN (SELECT plane_id FROM reservations)))" ;

            System.out.println(model);

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, model);
            stmt.setString(2, String.valueOf(LocalDate.now()));
            stmt.setString(3, model);

            System.out.println(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Plane p = new Plane(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                listPlane.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Plane p :listPlane
        ) {
            System.out.println(p);
        }
        return listPlane;
    }

    /**
     * Insereix un avió a la base de dades amb la informació proporcionada
     * @param registrationCode
     * @param model
     * @param mainColor
     * @param hoursFlied
     * @param conn
     */
    public void insertPlane(String registrationCode, String model, String mainColor, int hoursFlied, Connection conn) {
        try {

            String query = "INSERT INTO planes (registrationCode, model, mainColor, hoursFlied) " +
                    "VALUES ( ?,?,?,?)" ;


            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,registrationCode);
            stmt.setString(2,model);
            stmt.setString(3,mainColor);
            stmt.setInt(4,hoursFlied);

            stmt.execute();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Elimina un avió amb el codi de registre especificat
     * @param registrationCode
     * @param conn
     */
    public void deletePlane(String registrationCode, Connection conn){
        try {

            String query = "DELETE FROM planes" + " WHERE registration_code = ?" ;


            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,registrationCode);

            stmt.execute();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}