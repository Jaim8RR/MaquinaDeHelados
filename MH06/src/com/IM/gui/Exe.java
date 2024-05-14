/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IM.gui;

import com.IM.exceptions.NotEnoughMoneyException;
import com.IM.exceptions.QuantityExceededException;
import com.IM.exceptions.NotValidPositionException;
import com.IM.biz.IceCream;
import com.IM.biz.IceCreamMachine;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaime Riesgo, Sinahy Cacique
 */
public class Exe {

  
    static IceCream icecream;
    static IceCreamMachine IM = new IceCreamMachine();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<IceCream> iceCreams;
    static String position;

    public static void main(String[] args) {

        String choice;
       

        do {
            choice = menu();
            accions(choice);//accions(menu());
        } while (!choice.equalsIgnoreCase("S"));
        
    }

    public static void putMoney(IceCreamMachine IM, Scanner sc) {
        String choice;
        System.out.println("---------Introduzca monedas--------");
        showCoins();
        do {
            System.out.print("Elija una opción: ");
            choice = sc.nextLine();
            if ((!(choice.equalsIgnoreCase("A") || choice.equalsIgnoreCase("B") || choice.equalsIgnoreCase("C")
                    || choice.equalsIgnoreCase("D") || choice.equalsIgnoreCase("E") || choice.equalsIgnoreCase("F")
                    || choice.equalsIgnoreCase("S")))) {
                System.out.print("Opción incorrecta. ");
            } else {
                if (!choice.equalsIgnoreCase("S")) {
                    IM.setPurse(IM.getPurse() + translateChoiceToMoney(choice.toUpperCase()));
                    System.out.println("El dinero acumulado es: " + IM.getPurse() + "€");
                }
            }
        } while (!(choice.equalsIgnoreCase("S")));
    }

    public static double translateChoiceToMoney(String opcion) {
        switch (opcion) {
            case "A":
                return 0.05d;
            case "B":
                return 0.1d;
            case "C":
                return 0.2d;
            case "D":
                return 0.5d;
            case "E":
                return 1d;
            case "F":
                return 2d;
            default:
                return 0d;
        }
    }

    public static String menuDebug(Scanner sc) {
        String option;
        do {
            System.out.println("-------------------------");
            System.out.println("1.- Rellenar maquina");
            System.out.println("2.- Historial de ventas");
            System.out.println("S.- Salir");
            System.out.print("Elige una opción: ");
            option = sc.nextLine();
            if (!(option.equalsIgnoreCase("1") || option.equalsIgnoreCase("2") || option.equalsIgnoreCase("S"))) {
                System.out.println("Opcion no valida.");
            }
        } while (!(option.equalsIgnoreCase("1") || option.equalsIgnoreCase("2") || option.equalsIgnoreCase("S")));
        return option;
    }

    public static void showCoins() {
        System.out.println("A.- 0,05€");
        System.out.println("B.- 0,10€");
        System.out.println("C.- 0,20€");
        System.out.println("D.- 0,50€");
        System.out.println("E.- 1,00€");
        System.out.println("F.- 2,00€");
        System.out.println("S.- Salir");
    }

    public static void displayIcecreams() {
        try {
            ArrayList<IceCream> iceCreams = IM.showIceCreams();
            for (IceCream iceCream : iceCreams) {
                System.out.println(iceCream);
            }
        } catch (Exception ex) {
            System.out.println("No se ha podido recuperar la lista de helados");
            ex.printStackTrace();
        }
    }

    public static void exit() {
        System.out.println("------------------------------");
        System.out.println("Hasta la porximaa ...");
        System.out.println("Tu cambio: " + IM.getPurse() + "€");
        System.out.println("Ingresos: " + IM.getRevenue() + "€");
        System.out.println("------------------------------");
        try {
            // IC.saveData(FILE_NAME);
            System.out.println("Datos almacenados");
        } catch (Exception e) {
            System.out.println("Se ha producido un error al guardar los datos");
        }
    }

    public static String menu() {
        String option;
        System.out.println("--------------Menú principal-----------");
        System.out.println("1.- Mostrar helados");
        System.out.println("2.- Introducir monedas");
        System.out.println("3.- Pedir helado");
        System.out.println("S.- Salir y apagar máquina de helados");
        do {
            System.out.println("--------------------------------------");
            System.out.print("Introduzca una opción: ");
            option = sc.nextLine();
        } while (!(option.equals("1") || option.equals("2") || option.equals("3") || option.equalsIgnoreCase("S")));
        return option;
    }

    private static void accions(String opcion) {
        if (opcion.equals("1")) {
            displayIcecreams();
        } else if (opcion.equals("2")) {
            putMoney(IM, sc);
        } else if (opcion.equals("3")) {
                System.out.println("------------Pedir Helado-------------");
                System.out.print("Introduzca la posición: ");
                position = sc.nextLine();
                try {
                    icecream = IM.getIceCreamFromMachine(position);
                    if (icecream != null) {
                        System.out.println("Aquí tiene su " + icecream.getName() + " de tipo " + icecream.getType());
                        System.out.println("No olvide su cambio: " + IM.getPurse() + "€");
                        IM.setPurse(0);
                    }
                } catch (NotValidPositionException e) {
                    System.out.println("Posición introducida inexistente");
                } catch (QuantityExceededException e) {
                    System.out.println("No quedan helados en esa posición");
                } catch (NotEnoughMoneyException e) {
                    System.out.println("No tiene dinero suficiente para ese helado");
                } catch (Exception e) {
                    System.out.println("Se ha producido un error inesperado. Por favor, contacte con el administrador.");
                }
        }
    }

}
