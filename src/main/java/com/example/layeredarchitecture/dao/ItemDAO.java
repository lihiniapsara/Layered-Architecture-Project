package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;

    public void saveItems(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    public void updateItems(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    public void deleteItems(String code) throws SQLException, ClassNotFoundException ;

    public boolean exitItems(String code) throws SQLException, ClassNotFoundException ;


    public String genarateNewId() throws SQLException, ClassNotFoundException;

    ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException;
}
