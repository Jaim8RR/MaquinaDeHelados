/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IM.implement;

import java.sql.*;
import com.IM.biz.IceCream;
import com.IM.biz.Sales;
import com.IM.dao.interfaces.SalesDAO;
import java.util.ArrayList;

/**
 *
 * @author Jaime Riesgo
 */
public class SalesDAOimpl implements SalesDAO, AutoCloseable {
    static {
        try {
            Class.forName(com.IM.utils.configuration.DRIVER);
        } catch (Exception e) {
            System.out.println("El driver jdbc no carga!");
        }
    }
    Connection con = null;

    public SalesDAOimpl() throws Exception {
        con = DriverManager.getConnection(com.IM.utils.configuration.URL);
        System.out.println("mondongo");
    }

    @Override
    public void close() throws Exception {//abril , cerral
        con.close();
    }

  
  

    @Override
    public ArrayList<Sales> getSales() throws Exception {
        ArrayList<Sales> sales = new ArrayList<>();
        String sql = "select * from venta";
        try (PreparedStatement pstm = con.prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                sales.add(new Sales(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (Exception e) {
            throw e;
        }
        return sales;
    }

    @Override
    public void saveSale(IceCream iceCream) throws Exception {
        String sql = "insert into venta values(datetime('now'), ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, iceCream.getPosition());
            pstm.setString(2, iceCream.getName());
            pstm.setDouble(3, iceCream.getCost());
            pstm.setString(4, iceCream.getType());
            pstm.setInt(5, iceCream.getQuantity());
            pstm.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
