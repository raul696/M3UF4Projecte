import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;


public class ReservationService {

    /**
     * Obté totes les reserves de la base de dades
     * @param conn
     * @return Retorna un ArrayList d'objectes Reservation
     * @throws SQLException
     */
    public ArrayList<Reservation> getAllReservations(Connection conn) throws SQLException {
        ArrayList<Reservation> listReservation = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reservations");
            while (rs.next()) {
                Reservation r = new Reservation(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getTimestamp(4),rs.getTimestamp(5));
                listReservation.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listReservation;
    }

    /**
     * Inserta una reserva a la base de dades amb la informació proporcionada
     * @param clientId
     * @param planeId
     * @param startDate
     * @param endDate
     * @param conn
     */
    public void insertReservation( int clientId, int planeId, Timestamp startDate, Timestamp endDate,Connection conn) {
        try {

            String query = "INSERT INTO reservations (client_id,plane_id,start_date,end_date) " +
                    "VALUES (?,?,?,?)" ;

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,clientId);
            stmt.setInt(2,planeId);
            stmt.setTimestamp(3,startDate);
            stmt.setTimestamp(4,endDate);

            stmt.execute();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Elimina una reserva amb el ID especificat de la base de dades
     * @param reservation_id
     * @param conn
     */
    public void deleteReservation(int reservation_id, Connection conn){
        try {
            String query = "DELETE FROM reservations" + " WHERE reservation_id = ?" ;
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,reservation_id);
            stmt.execute();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Obté totes les reserves d'un client especificant el seu DNI
     * @param dni
     * @param conn
     * @return Retorna un ArrayList de objectes Reservation
     * @throws SQLException
     */
    public ArrayList<Reservation> getReservationsByClientDNI(String dni, Connection conn) throws SQLException {
        ArrayList<Reservation> listReservation = new ArrayList<>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reservations r INNER JOIN clients c ON r.client_id = c.client_id WHERE c.dni=\"" + dni + '"');
            while (rs.next()) {
                Reservation r = new Reservation(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getTimestamp(4),rs.getTimestamp(5));
                listReservation.add(r);
            }
        return listReservation;
    }
}