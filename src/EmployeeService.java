import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeService {
    public ArrayList<Employee> getAllEmployee(Connection conn) throws SQLException {
        ArrayList<Employee> listEmployee = new ArrayList<>();
        try {
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM clients");
            while(rs.next()){
                Employee e =new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                listEmployee.add(e);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        return listEmployee;
    }
}
