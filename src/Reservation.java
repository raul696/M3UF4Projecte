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
}
