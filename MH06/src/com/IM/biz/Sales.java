/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IM.biz;

/**
 *
 * @author Jaime Riesgo
 */
public class Sales {

    private String time;
    private String position;
    private String name;
    private Double price;
    private String type;
    private int Quantity;

    public Sales(String time, String position, String name, Double price, String type, int Quantity) {
        this.time = time;
        this.position = position;
        this.name = name;
        this.price = price;
        this.type = type;
        this.Quantity = Quantity;
    }

    

    @Override
    public String toString() {
        return time + " :: " + position + " :: " + name + " :: " + price + "€ :: " + type + " :: " + Quantity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

}
