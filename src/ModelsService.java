import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;


public class ModelsService {
    public ArrayList<Model> getAllModels(Connection conn) throws SQLException {
        ArrayList<Model> listModel = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
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

    public void insertarModels(int id, String modelName, String brand, short pax, String licenceType, float fuelCapacity, short maxSpeed, int consumPerHour, int maxTakeoffWeight, int emptyWeight, Connection conn) {
        try {

            String query = "INSERT INTO clients (id,modelName,brand,pax,licenceType,fuelCapacity,maxSpeed,consumPerHour,maxTakeoffWeight,emptyWeight) " +
                    "VALUES ( ?,?,?,?,?,?,?,?,?,?)";


            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);
            stmt.setString(2, modelName);
            stmt.setString(3, brand);
            stmt.setShort(4, pax);
            stmt.setString(5, licenceType);
            stmt.setFloat(6,fuelCapacity);
            stmt.setShort(7,maxSpeed);
            stmt.setInt(8,consumPerHour);
            stmt.setInt(9,maxTakeoffWeight);
            stmt.setInt(10,emptyWeight);

            stmt.execute();

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}