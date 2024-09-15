/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IM.dao.interfaces;

import com.IM.biz.IceCream;
import java.util.ArrayList;

/**
 *
 * @author dev
 */
public interface IceCreamDAO  {
   
    public IceCream getIceCreamByPos(String posicion) throws Exception;

    public void updateIceCream(IceCream h) throws Exception;

    public ArrayList<IceCream> getIceCream() throws Exception;

    public void refill() throws Exception;
}
