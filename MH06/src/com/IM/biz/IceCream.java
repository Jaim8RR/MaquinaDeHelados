/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IM.biz;

import com.IM.utils.Utils;

/**
 *
 * @author enriquenogal
 */
public class IceCream {
    private String position;
    private String name;
    private double cost;
    private String type;
    private int quantity = 5;

    public IceCream(String position, String name, double cost, String type) {
        this.position = position;
        this.name = name;
        this.cost = Utils.roundTwoDecimals(cost);
        this.type = type;
    }
    
    public IceCream(String position, String name, double cost, String type, int quantity) {
        this.position = position;
        this.name = name;
        this.cost = Utils.roundTwoDecimals(cost);
        this.type = type;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  position + " :: " + name + " :: " + cost + "€ :: " + type + " :: " + quantity ;
    }
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public String getPosition() {
        return position;
    }
}
