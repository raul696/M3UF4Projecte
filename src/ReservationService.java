import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReservationService {
    public ArrayList<Reservation> getAllReservations() {
        PlanesService p = new PlanesService();
        ArrayList<Reservation> listReservation = new ArrayList<>();

        try {
            Statement stmt = p.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reservations");
            String date = String.valueOf(rs.getDate(4));
            while (rs.next()) {
                Reservation r = new Reservation(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getTimestamp(4),rs.getTimestamp(5));
                listReservation.add(r);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listReservation;
    }
}
