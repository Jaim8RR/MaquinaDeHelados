/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IM.biz;

import com.IM.exceptions.NotEnoughMoneyException;
import com.IM.exceptions.NotValidPositionException;
import com.IM.exceptions.QuantityExceededException;
import com.IM.implement.IceCreamDAOimpl;
import com.IM.implement.SalesDAOimpl;
import com.IM.utils.Utils;
import java.util.ArrayList;



/**
 *
 * @author Jaime
 */
public class IcecreamMachine {

    private double purse = 0;
    private double revenue = 0;
    
    public ArrayList<IceCream> showIceCreams() throws Exception {
        ArrayList<IceCream> IceCreamList;
        try (IceCreamDAOimpl IceCream = new IceCreamDAOimpl(){}) {
            IceCreamList = (ArrayList) IceCream.getIceCream();
        } catch (Exception e) {
            throw e;
        }
        return IceCreamList;
    }
    public ArrayList<Sales> showSales() throws Exception {
        ArrayList<Sales> SalesList;
        try (SalesDAOimpl sales = new SalesDAOimpl()) {
            SalesList = (ArrayList) sales.getSales();
        } catch (Exception ex) {
            throw ex;
        }
        return SalesList;

    }
    public IceCream getIceCreamFromMachine(String position) throws Exception, NotValidPositionException, QuantityExceededException, NotEnoughMoneyException {
        IceCream iceCream = null;
   
        try (IceCreamDAOimpl helado = new IceCreamDAOimpl(); SalesDAOimpl ventas = new SalesDAOimpl()) {
            iceCream = helado.getIceCreamByPos(position);
            if (iceCream == null) {
                throw new NotValidPositionException();
            } else if (iceCream.getQuantity()<= 0) {
                throw new QuantityExceededException();
            } else if (iceCream.getCost()> purse) {
                throw new NotEnoughMoneyException("No tienes dinero suficiente almacenado");
            } else {
                this.setPurse(this.purse - iceCream.getCost());
                this.setRevenue(iceCream.getCost());
                iceCream.setQuantity(iceCream.getQuantity()- 1);
                helado.updateIceCream(iceCream);
                ventas.saveSale(iceCream);
            }
        } catch (Exception e) {
            throw e;
        }

        return iceCream;
    }


  



    public double getPurse() {
        return purse;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setPurse(double purse) {
        this.purse = Utils.roundTwoDecimals(purse);
    }

    public void setRevenue(double revenue) {
        this.revenue = Utils.roundTwoDecimals(revenue);
    }

}
