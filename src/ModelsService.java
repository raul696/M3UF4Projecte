import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelsService {
    PlanesService p = new PlanesService();
    public ArrayList<Model> getAllModels() {
        ArrayList<Model> listModel = new ArrayList<>();
        try {
            Statement stmt = p.connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM models");
            while (rs.next()) {
                Model m = new Model(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getShort(4), rs.getString(5), rs.getInt(6), rs.getShort(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
                listModel.add(m);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listModel;
    }

}
