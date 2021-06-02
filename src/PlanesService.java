import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;

public class PlanesService {


    /**
     * Iniciem una connexió per afegir totes les dades de la taula planes a un ArrayList que creem anomenada
     * listPlane
     * @param conn
     * @return
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
            System.out.println(e);
        }
        return listPlane;
    }

    /**
     * Iniciem una connexió a la base de dades per inserir a la taula planes les dades que ens introdueixen desde el
     * main
     * @param registrationCode
     * @param model
     * @param mainColor
     * @param hoursFlied
     * @param conn
     */
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

    /**
     * Iniciem una connexió a la base de dades i segons el "registration_code" que ens introdueixen podem eliminar
     * les dades que pertanyen a aquell codi de la taula planes
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
            System.out.println(e);
        }
    }
}