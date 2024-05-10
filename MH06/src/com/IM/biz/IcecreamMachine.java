/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IM.biz;

//import com.IM.exceptions.NotEnoughMoneyException;
//import com.IM.exceptions.QuantityExceededException;
//import com.IM.exceptions.NotValidPositionException;
import com.IM.utils.Utils;
import java.util.ArrayList;
//import java.io.File;
//import java.io.FileWriter;
//import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Jaime
 */
public class IcecreamMachine {

    private double purse = 0;
    private double revenue = 0;
    
    public ArrayList<IceCream> mostrarHelados() throws Exception {
        ArrayList<IceCream> IceCreamList;
        try (IceCreamDAO IceCream = new IceCreamDAO()) {
            IceCreamList = (ArrayList) IceCream.getHelado();
        } catch (Exception e) {
            throw e;
        }
        return IceCreamList;
    }
    public ArrayList<Sales> mhMostrarVentas() throws Exception {
        ArrayList<Sales> SalesList;
        try (SalesDAO venta = new SalesDAO()) {
            SalesList = (ArrayList) venta.getVentas();
        } catch (Exception ex) {
            throw ex;
        }
        return SalesList;
    }
    
//    
//    public IcecreamMachine(String fileName) throws Exception{
//        File f = new File(fileName);
//        if (!f.exists() || !f.isFile()) {
//            throw new Exception();
//        } else {
//            try (Scanner scFile = new Scanner(f)) {
//                String[] datos;
//                IceCream h;
//                while (scFile.hasNextLine()) {
//                    datos = scFile.nextLine().split(",");
//                    h = new IceCream(datos[0], datos[1], Double.parseDouble(datos[2]), datos[3], Integer.parseInt(datos[4]));
//                    this.Icecreams.put(h.getPosition(), h);
//                }        
//            } catch (Exception e) {
//                throw e;
//            }
//        }
//    }
//
//    public IcecreamMachine() {
//        Icecreams.put("00", new IceCream("00", "ChocoBomba", 1.1, "tarrina"));
//        Icecreams.put("01", new IceCream("01", "FresaGuapi", 0.8, "palo"));
//        Icecreams.put("02", new IceCream("02", "LimónCanela", 1.5, "cucurucho"));
//        Icecreams.put("10", new IceCream("10", "FrigLemon", 1.8, "tarrina"));
//        Icecreams.put("11", new IceCream("11", "PiñaHelada", 1.0, "palo"));
//        Icecreams.put("12", new IceCream("12", "MoraGuay", 1.2, "cucurucho"));
//        Icecreams.put("20", new IceCream("20", "ChocoLoco", 1.8, "tarrina"));
//        Icecreams.put("21", new IceCream("21", "TuttiFrutti", 1.3, "palo"));
//        Icecreams.put("22", new IceCream("22", "Mentazul", 1.2, "cucurucho"));
//    }
//    
//    public void saveData(String fileName) throws Exception{
//        try (FileWriter fw = new FileWriter(new File(fileName))) {
//            for (IceCream h : this.Icecreams.values()) {
//                fw.write(h.getPosition()+ "," + h.getName() + "," + h.getCost() + "," 
//                        + h.getType() + "," + h.getQuantity() + "\n");
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//
//    public IceCream getIcecream(String posicion) throws Exception {
//        IceCream h = null;
//        if (!this.Icecreams.containsKey(posicion)) {
//            throw new NotValidPositionException();
//        } else if (this.Icecreams.get(posicion).getQuantity() <= 0) {
//            throw new QuantityExceededException();
//        } else if (this.Icecreams.get(posicion).getCost() > purse) {
//            throw new NotEnoughMoneyException();
//        } else {
//            this.Icecreams.get(posicion).setQuantity(this.Icecreams.get(posicion).getQuantity() - 1);
//            this.setPurse(this.getPurse() - this.Icecreams.get(posicion).getCost());
//            this.setRevenue(this.getRevenue() + this.Icecreams.get(posicion).getCost());
//            return this.Icecreams.get(posicion);
//        }
//    }
//
//    @Override
//    public String toString() {
//        String s = "";
//        for (IceCream value : this.Icecreams.values()) {
//            s += value.toString() + "\n";
//        }
//        return s;
//    }

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
