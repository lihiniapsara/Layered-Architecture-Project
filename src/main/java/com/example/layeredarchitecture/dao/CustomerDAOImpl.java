package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");

        ArrayList<CustomerDTO> allCustomers=new ArrayList<>();
        while (rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }
@Override
    public  void saveCustomers(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
        pstm.setString(1, customer.getId());
        pstm.setString(2, customer.getName());
        pstm.setString(3, customer.getAddress());
        pstm.executeUpdate();
    }
    @Override
    public void updateCustomers(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        pstm.setString(1, customer.getId());
        pstm.setString(2, customer.getName());
        pstm.setString(3, customer.getAddress());
        pstm.executeUpdate();
    }
@Override
    public void deleteCustomers(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setString(1, id);
        pstm.executeUpdate();
    }
@Override
    public boolean exitCustomers(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
        pstm.setString(1, id);
        return pstm.executeQuery().next();
    }

   public String searchCustomer(String newValue) throws SQLException, ClassNotFoundException {
       Connection connection = DBConnection.getDbConnection().getConnection();

       PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
       pstm.setString(1, newValue + "");
       ResultSet rst = pstm.executeQuery();
       if (rst.next()){
           String name = rst.getString(2);
           return name;
       }
       return null;
    }


 /*   public ArrayList<String> loadAllCustomerIds() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT id FROM Customer");


        ArrayList<String> allCustomers=new ArrayList<>();
        while (rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"));
            allCustomers.add();
        }
        return allCustomers;
    }*/

    public String genarateNewId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");

        if (rst.next()){
            return rst.getString("id");
        }
        return null;
    }
}


