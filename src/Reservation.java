import javax.xml.crypto.Data;

public class Reservation {

    private int id;
    private int clientId;
    private int planeId;
    private Date startDate;
    private Date endDate;


    public Reservation(int id, int clientId, int planeId, Date startDate, Date endDate) {
        this.id = id;
        this.clientId = clientId;
        this.planeId = planeId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
