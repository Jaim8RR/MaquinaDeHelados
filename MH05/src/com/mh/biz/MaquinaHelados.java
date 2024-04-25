/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mh.biz;

import com.mh.exceptions.*;
import com.mh.utils.Utils;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author enriquenogal
 */
public class MaquinaHelados {

    private double monedero = 0;
    private double ingresos = 0;
    private TreeMap<String, Helado> helados = new TreeMap<String, Helado>();
    
    public MaquinaHelados(String fileName) throws Exception{
        File f = new File(fileName);
        if (!f.exists() || !f.isFile()) {
            throw new Exception();
        } else {
            try (Scanner scFile = new Scanner(f)) {
                String[] datos;
                Helado h;
                while (scFile.hasNextLine()) {
                    datos = scFile.nextLine().split(",");
                    h = new Helado(datos[0], datos[1], Double.parseDouble(datos[2]), datos[3], Integer.parseInt(datos[4]));
                    this.helados.put(h.getPosicion(), h);
                }        
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public MaquinaHelados() {
        helados.put("00", new Helado("00", "ChocoBomba", 1.1, "tarrina"));
        helados.put("01", new Helado("01", "FresaGuapi", 0.8, "palo"));
        helados.put("02", new Helado("02", "LimónCanela", 1.5, "cucurucho"));
        helados.put("10", new Helado("10", "FrigLemon", 1.8, "tarrina"));
        helados.put("11", new Helado("11", "PiñaHelada", 1.0, "palo"));
        helados.put("12", new Helado("12", "MoraGuay", 1.2, "cucurucho"));
        helados.put("20", new Helado("20", "ChocoLoco", 1.8, "tarrina"));
        helados.put("21", new Helado("21", "TuttiFrutti", 1.3, "palo"));
        helados.put("22", new Helado("22", "Mentazul", 1.2, "cucurucho"));
    }
    
    public void guardarDatos(String fileName) throws Exception{
        try (FileWriter fw = new FileWriter(new File(fileName))) {
            for (Helado h : this.helados.values()) {
                fw.write(h.getPosicion()+ "," + h.getNombre() + "," + h.getPrecio() + "," 
                        + h.getTipo() + "," + h.getCantidad() + "\n");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Helado pedirHelado(String posicion) throws Exception {
        Helado h = null;
        if (!this.helados.containsKey(posicion)) {
            throw new NotValidPositionException();
        } else if (this.helados.get(posicion).getCantidad() <= 0) {
            throw new QuantityExceededException();
        } else if (this.helados.get(posicion).getPrecio() > monedero) {
            throw new NotEnoughMoneyException();
        } else {
            this.helados.get(posicion).setCantidad(this.helados.get(posicion).getCantidad() - 1);
            this.setMonedero(this.getMonedero() - this.helados.get(posicion).getPrecio());
            this.setIngresos(this.getIngresos() + this.helados.get(posicion).getPrecio());
            return this.helados.get(posicion);
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (Helado value : this.helados.values()) {
            s += value.toString() + "\n";
        }
        return s;
    }

    public double getMonedero() {
        return monedero;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setMonedero(double monedero) {
        this.monedero = Utils.redondeoDosDecimales(monedero);
    }

    public void setIngresos(double ingresos) {
        this.ingresos = Utils.redondeoDosDecimales(ingresos);
    }

}
