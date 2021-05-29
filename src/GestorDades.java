import java.sql.SQLException;
import java.util.ArrayList;

public class GestorDades {
    PlanesService p = new PlanesService();
    ModelsService m = new ModelsService();
    ReservationService r = new ReservationService();
    java.sql.Connection conn;

    public void startConnection() throws SQLException {
        conn = Connection.openConnection();
    }

    public void getAllModels(){
        try {
            ArrayList<Model> listModel = m.getAllModels(conn);
            for (Model m :listModel) {
                System.out.println(m);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
