import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;


public class ClientsService {

    /**
     * Fa una consulta a la base de dades per obtenir tots els clients i retorna un ArrayList de objectes Client
     * @param conn Connexió amb la base de dades
     * @return listClient
     * @throws SQLException
     */

    public ArrayList<Client> getAllClients(Connection conn) throws SQLException {
        ArrayList<Client> listClient = new ArrayList<>();
        try {
            Statement stmt= conn.createStatement();
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

    /**
     * Consulta la base de dades per retornar el client que tingui el DNI especificat, en cas de que no existeixi retornará null
     * @param conn Connexió a la base de dades
     * @param dni DNI per cercar client
     * @return Objecte Client
     * @throws SQLException
     */
    public Client getClientByDni(Connection conn, String dni) throws SQLException {
        Client c = null;
        try {
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM clients WHERE dni=\"" + dni + '"');

            if (rs.next()){
                c = new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));

            }

            }catch (Exception e){
            System.out.println(e);
        }
        return c;
    }

    /**
     * Inserta nous clients a la base de dades amb la informació introduïda
     * @param dni
     * @param name
     * @param surname1
     * @param surname2
     * @param licence
     * @param conn
     */
    public void insertClients(String dni, String name, String surname1, String surname2, String licence, Connection conn) {
        try {

            String query = "INSERT INTO clients (dni, name, surname1, surname2, licence_type) " +
                    "VALUES ( ?,?,?,?,?)" ;


            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,dni);
            stmt.setString(2,name);
            stmt.setString(3,surname1);
            stmt.setString(4,surname2);
            stmt.setString(5,licence);

            stmt.execute();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Elimina el client de la base de dades amb el DNI especificat
     * @param dni
     * @param conn Connexió amb la base de dades
     */

    public void deleteClient(String dni, Connection conn){
        try {

            String query = "DELETE FROM clients" + " WHERE dni = ?" ;


            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,dni);

            stmt.execute();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
