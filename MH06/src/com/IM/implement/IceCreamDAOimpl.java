/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IM.implement;

import com.IM.biz.IceCream;
import com.IM.dao.interfaces.IceCreamDAO;
import java.util.ArrayList;
import java.sql.*;
import com.IM.utils;

/**
 *
 * @author dev
 */
public class IceCreamDAOimpl implements IceCreamDAO, AutoCloseable {
    static{
try{
    Class.forName(com.IM.utils.configuration.DRIVER);
} catch (Exception e) {
            System.out.println("No se ha podido cargar el driver de la jdbc ");
        }
}

    @Override
    public IceCream getIceCreamByPos(String posicion) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateICeCream(IceCream h) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<IceCream> getIceCream() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void refill() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
