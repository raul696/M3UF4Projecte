import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientsService {
    PlanesService p = new PlanesService();
    public ArrayList<Client> getAllClients() {
        ArrayList<Client> listClient = new ArrayList<>();
        try {
            Statement stmt= p.connection.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM clients");
            while(rs.next()){
                Client c =new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                listClient.add(c);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        return listClient;
    }
}
