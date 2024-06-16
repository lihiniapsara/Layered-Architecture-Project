package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;

    public  void saveCustomers(CustomerDTO customer) throws SQLException, ClassNotFoundException ;
    public void updateCustomers(CustomerDTO customer) throws SQLException, ClassNotFoundException ;

    public void deleteCustomers(String id) throws SQLException, ClassNotFoundException ;

    public boolean exitCustomers(String id) throws SQLException, ClassNotFoundException;

    public  String genarateNewId() throws SQLException,ClassNotFoundException;

    String searchCustomer(String newValue);
}
