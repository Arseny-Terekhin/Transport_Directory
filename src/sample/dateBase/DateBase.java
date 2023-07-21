package sample.dateBase;

import java.sql.*;

public class DateBase {
    Connection con;
    Statement statement;
    ResultSet res;

    public Connection getDBConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://127.0.0.1:3306/transport";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(connectionString, "root", "1234");
        return con; }

    public ResultSet table(String str){
        try{
            statement = getDBConnection().createStatement();
            res = statement.executeQuery(str);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void delete(String str){
        try{
            PreparedStatement preparedStatement = getDBConnection().prepareStatement(str);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, String brand, String model, String category, String number, String type, int date, String trailer){
        try{
            PreparedStatement statement = getDBConnection().prepareStatement("UPDATE trans set car_brand = ?, car_model = ?, car_category = ?, state_number = ?, car_type= ?, release_date = ?, trailer = ?   where id = ?");
            statement.setString(1, brand);
            statement.setString(2, model);
            statement.setString(3, category);
            statement.setString(4, number);
            statement.setString(5, type);
            statement.setInt(6, date);
            statement.setString(7, trailer);
            statement.setInt(8, id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insert(String brand, String model, String category, String number, String type, int date, String trailer){
        try{
            PreparedStatement statement = getDBConnection().prepareStatement("INSERT  into trans(car_brand,car_model ,car_category ,state_number ,car_type ,release_date ,trailer  ) values (?,?,?,?,?,?,?)");
            statement.setString(1, brand);
            statement.setString(2, model);
            statement.setString(3, category);
            statement.setString(4, number);
            statement.setString(5, type);
            statement.setInt(6, date);
            statement.setString(7, trailer);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean numSearch(String num) {
        try {
            statement = getDBConnection().createStatement();
            boolean v = false;
            res = statement.executeQuery("SELECT * FROM trans");
            while (res.next()) {
                if (res.getString("state_number").equals(num)) {
                    v = true;
                    break;
                }
            }
            return v;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }





}
