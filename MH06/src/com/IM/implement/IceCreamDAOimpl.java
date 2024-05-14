/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IM.implement;

import com.IM.biz.IceCream;
import com.IM.dao.interfaces.IceCreamDAO;
import java.util.ArrayList;
import java.sql.*;
import com.IM.utils.*;

/**
 *
 * @author dev
 */
public class IceCreamDAOimpl implements IceCreamDAO, AutoCloseable {
    static {
        try {
            Class.forName(com.IM.utils.configuration.DRIVER);
        } catch (Exception e) {
            System.out.println("El driver jdbc no carga!");
        }
    }
    Connection con = null;

    public IceCreamDAOimpl() throws Exception {
        con = DriverManager.getConnection(com.IM.utils.configuration.URL);
    }

    @Override
    public IceCream getIceCreamByPos(String posicion) throws Exception {
    
        IceCream iceCream = null;
        ResultSet rs =null;
        String sql = "SELECT * FROM helado WHERE posicion = ?"; 
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, posicion);
            rs = ps.executeQuery();
            if (rs.next()) {
                iceCream = new IceCream(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return iceCream;
    }

    @Override
    public void updateIceCream(IceCream h) throws Exception {
    
        String sql = "update helado set cantidad = ?, nombre = ?, tipo = ?, precio = ? WHERE posicion = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, h.getQuantity());
            ps.setString(2, h.getName());
            ps.setString(3, h.getType());
            ps.setDouble(4, h.getCost());
            ps.setString(5, h.getPosition());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ArrayList<IceCream> getIceCream() throws Exception {
   
             ArrayList<IceCream> IceCreams = new ArrayList<IceCream>();
        IceCream iceCream;
        String sql = "SELECT * FROM helado"; //quitar el asterisco para poner el listado de los campos
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                iceCream = new IceCream(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5));
                IceCreams.add(iceCream);
            }
        } catch (Exception e) {
            System.out.println("._. Ha ocurrido un error");
        }
        return IceCreams;
    }

    @Override
    public void refill() throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String sql = "update helado set cantidad = 5 ";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void close() throws Exception {
       //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        con.close();
    }
    
    
}
