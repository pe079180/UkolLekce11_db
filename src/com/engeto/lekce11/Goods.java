package com.engeto.lekce11;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;


public class Goods implements GoodsMethods {
    //    private ArrayList  itemList = new ArrayList();
    private  final String URL = "jdbc:mysql://localhost:3306/engeto";
    private  final String USER = "test";
    private  final String PASSWORD = "test";

    @Override
    public  Item loadItemById(Integer id) {
        Item resultItem = new Item(null, null, null, null, null, null, null);
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = con.createStatement();
            statement.executeQuery("select * from engeto.item where id=" + id.toString());
            ResultSet result = statement.getResultSet();
            if (result.next()) {
                resultItem.setId(result.getInt("id"));
                resultItem.setPartNo(result.getString("part_no"));
                resultItem.setSerialNo(result.getString("serial_no"));
                resultItem.setName(result.getString("name"));
                resultItem.setDescription(result.getString("description"));
                resultItem.setNumberInStock(result.getInt("number_in_stock"));
                resultItem.setPrice(result.getBigDecimal("price"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultItem;
    }

    @Override
    public  void deleteAllOutOfStockItems() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public  List<Item> loadAllAvailableItems() {
        return null;
    }

    @Override
    public  void saveItem(Item item) {
        final String INSERT = "INSERT INTO engeto.item (part_no,serial_no,name,description,number_in_stock,price) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            preparedStatement = con.prepareStatement(INSERT);
            preparedStatement.setString(1, item.getPartNo());
            preparedStatement.setString(2, item.getSerialNo());
            preparedStatement.setString(3, item.getName());
            preparedStatement.setString(4, item.getDescription());
            preparedStatement.setInt(5, item.getNumberInStock());
            preparedStatement.setBigDecimal(6, item.getPrice());

            int rowCount = preparedStatement.executeUpdate();
            System.out.println(""+rowCount+" row inserted ...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            preparedStatement.close();
//        }

    }

    @Override
    public  void updatePrice(Integer id, BigDecimal newPrice) {

    }
}
