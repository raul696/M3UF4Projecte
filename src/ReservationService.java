import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ReservationService {

    public void getAllReservations(Connection conn) {
        ArrayList<Reservation> listReservation = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM reservations");
            String date = String.valueOf(rs.getDate(4));
            while (rs.next()) {
                Reservation r = new Reservation(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getTimestamp(4),rs.getTimestamp(5));
                listReservation.add(r);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (Reservation r :listReservation
        ) {
            System.out.println(r);
        };
    }
}
