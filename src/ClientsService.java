import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientsService {
    Connection c = new Connection();
    public void getAllClients() {
        ArrayList<Client> listClient = new ArrayList<>();
        try {
            Statement stmt= c.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM clients");
            while(rs.next()){
                Client c =new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                listClient.add(c);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        for (Client c :listClient
        ) {
            System.out.println(c);
        };
    }
}
