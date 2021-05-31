import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Reservation {

    private int id;
    private int clientId;
    private int planeId;
    private Timestamp startDate;
    private Timestamp endDate;


    public Reservation(int id, int clientId, int planeId, Timestamp startDate, Timestamp endDate) {
        this.id = id;
        this.clientId = clientId;
        this.planeId = planeId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Reservation(int id, int clientId, int planeId, Timestamp startDate) {
        this.id = id;
        this.clientId = clientId;
        this.planeId = planeId;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", planeId=" + planeId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public int getPlaneId() {
        return planeId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }
}
