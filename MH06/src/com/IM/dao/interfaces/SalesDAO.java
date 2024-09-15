/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IM.dao.interfaces;

import com.IM.biz.IceCream;
import com.IM.biz.Sales;
import java.util.ArrayList;

/**
 *
 * @author Jaime Riesgo
 */
public interface SalesDAO {
    public void saveSale(IceCream iceCream) throws Exception;

    public ArrayList<Sales> getSales() throws Exception;
}
