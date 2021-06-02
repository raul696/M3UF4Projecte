import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

public class EmployeeService {
    /**
     * Iniciem una connexió a la base de dades i afegim totes les dades de la taula employees a un ArrayList que hem
     * creat anomenada Employee
     * @param conn
     * @return la Array creada de empleats
     * @throws SQLException
     */
    public ArrayList<Employee> getAllEmployees(Connection conn) throws SQLException {
        ArrayList<Employee> listEmployees = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                listEmployees.add(e);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return listEmployees;
    }

    /**
     * Iniciem una connexió per afegir clients a la taula employees amb les dades demanades al main
     * @param dni
     * @param name
     * @param surname1
     * @param surname2
     * @param conn
     */
    public void insertEmployees(String dni, String name, String surname1, String surname2, Connection conn) {
        try {

            String query = "INSERT INTO employees (dni, name, surname1, surname2) " +
                    "VALUES ( ?,?,?,?)";


            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, dni);
            stmt.setString(2, name);
            stmt.setString(3, surname1);
            stmt.setString(4, surname2);

            stmt.execute();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Iniciem una connexió on rebem un String de DNI i fem una consulta SQL que borrem tots els empleats on el
     * DNI sigui igual al introduit per l'usuari
     * @param dni
     * @param conn
     */
    public void deleteEmpleat(String dni, Connection conn){
        try {

            String query = "DELETE FROM employees" + " WHERE dni = ?" ;


            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,dni);

            stmt.execute();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}