import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

public class EmployeeService {
    /**
     * Obté tots els empleats de la base de dades i retorna un ArrayList de objectes Employee
     * @param conn connexió amb la base de dades
     * @return
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
     * Obté la informació d'un empleat amb el DNI especificat
     * @param conn Connexió amb la base de dades
     * @param dni DNI per a la cerca
     * @return
     * @throws SQLException
     */
    public Employee getEmployeeByDni(Connection conn, String dni) throws SQLException {
        Employee employee = null;
        try {
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM employees WHERE dni=\"" + dni + '"');

            if (rs.next()){
                employee = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return employee;
    }

    /**
     * Inserta un empleat a la base de dades amb la informació proporcionada
     * @param dni
     * @param name
     * @param surname1
     * @param surname2
     * @param conn Connexió amb la base de dades
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
     * Elimina un empleat de la base de dades amb el DNI especificat
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