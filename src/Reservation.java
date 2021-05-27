import java.time.LocalDateTime;

public class Reservation {

    private int id;
    private int clientId;
    private int planeId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    public Reservation(int id, int clientId, int planeId, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.clientId = clientId;
        this.planeId = planeId;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}
