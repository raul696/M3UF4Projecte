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

    public void insertarModels( String modelName, String brand, short pax, String licenceType, float fuelCapacity, short maxSpeed, int consumPerHour, int maxTakeoffWeight, int emptyWeight, Connection conn) {
        try {

            String query = "INSERT INTO clients (modelName,brand,pax,licenceType,fuelCapacity,maxSpeed,consumPerHour,maxTakeoffWeight,emptyWeight) " +
                    "VALUES ( ?,?,?,?,?,?,?,?,?)";


            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, modelName);
            stmt.setString(2, brand);
            stmt.setShort(3, pax);
            stmt.setString(4, licenceType);
            stmt.setFloat(5,fuelCapacity);
            stmt.setShort(6,maxSpeed);
            stmt.setInt(7,consumPerHour);
            stmt.setInt(8,maxTakeoffWeight);
            stmt.setInt(9,emptyWeight);

            stmt.execute();

        } catch (Exception e) {
            System.out.println(e);

        }
    }
    public void deleteModel(String modelName, Connection conn){
        try {

            String query = "DELETE FROM models" + " WHERE model_name = ?" ;


            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,modelName);

            stmt.execute();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}