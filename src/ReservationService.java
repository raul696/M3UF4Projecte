import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;


public class ReservationService {
    /**
     * Iniciem una connexió a la base de dades i seleccionem totes les dades de la taula reservations i les
     * afegim a una ArrayList anomenada listReservation
     * @param conn
     * @return
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
            System.out.println(e);
        }
        return listReservation;
    }

    /**
     * Iniciem una connexió a la base de dades per afegir a la taula reservations les dades que ens introdueixen al
     * main
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
     * Iniciem una connexió i segons la reservation_id que ens han introduit borrem la reserva de la taula reservas
     * @param reservation_id
     * @param conn
     */
    public void deleteReservation(int reservation_id, Connection conn){
        try {

            String query = "DELETE FROM reservation" + " WHERE reservation_id = ?" ;


            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,reservation_id);

            stmt.execute();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}