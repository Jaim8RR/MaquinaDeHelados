/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.IM.gui;

import com.IM.exceptions.NotEnoughMoneyException;
import com.IM.exceptions.QuantityExceededException;
import com.IM.exceptions.NotValidPositionException;
import com.IM.biz.IceCream;
import com.IM.biz.IcecreamMachine;
import java.util.Scanner;

/**
 *
 * @author Jaime Riesgo, Sinahy Cacique
 */
public class Exe {
       static final String JBDC_DRIVER = "org.sqlite.JDBC";
       static IceCream icecream;
       static String position;
       static IcecreamMachine IM;
       static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        
        try {
            Class.forName(JBDC_DRIVER);
        } catch (Exception e) {
            System.out.println("El driver de la base de dato no se ha podido cargar");
        }
        String choice;
        IcecreamMachine im =null;
        
        do {
            choice = menu();
            accions(choice);
        } while (!choice.equalsIgnoreCase("S"));
        exit(im);
    }

    public static void putMoney(IcecreamMachine mh, Scanner sc) {
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
                    mh.setPurse(mh.getPurse() + translateChoiceToMoney(choice.toUpperCase()));
                    System.out.println("El dinero acumulado es: " + mh.getPurse() + "€");
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

    public static void showCoins() {
        System.out.println("A.- 0,05€");
        System.out.println("B.- 0,10€");
        System.out.println("C.- 0,20€");
        System.out.println("D.- 0,50€");
        System.out.println("E.- 1,00€");
        System.out.println("F.- 2,00€");
        System.out.println("S.- Salir");
    }

    public static void displayIcecreams(IcecreamMachine mh) {
        System.out.println("-----Listado de helados------");
        System.out.println(mh);
        System.out.println("-----------------------------");
        System.out.println("Dispones de " + mh.getPurse() + "€");
        System.out.println("-----------------------------");
    }

    public static void exit(IcecreamMachine mh) {
        System.out.println("-----------------------------");
        System.out.println("Apagando máquina de helados.....");
        System.out.println("No olvide recoger su cambio: " + mh.getPurse() + "€");
        System.out.println("Ingresos totales de la máquina de helados: " + mh.getRevenue() + "€");
        System.out.println("-----------------------------");
        try {
           // mh.saveData(FILE_NAME);
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
                displayIcecreams(IM);
            } else if (opcion.equals("2")) {
                putMoney(IM, sc);
            } else if (opcion.equals("3")) {
//                System.out.println("------------Pedir Helado-------------");
//                System.out.print("Introduzca la posición: ");
//                position = sc.nextLine();
//                try {
//                    icecream = IM.getIcecream(position);
//                    if (icecream != null) {
//                        System.out.println("Aquí tiene su " + icecream.getName() + " de tipo " + icecream.getType());
//                        System.out.println("No olvide su cambio: " + IM.getPurse() + "€");
//                        IM.setPurse(0);
//                    }
//                } catch (NotValidPositionException e) {
//                    System.out.println("Posición introducida inexistente");
//                } catch (QuantityExceededException e) {
//                    System.out.println("No quedan helados en esa posición");
//                } catch (NotEnoughMoneyException e) {
//                    System.out.println("No tiene dinero suficiente para ese helado");
//                } catch (Exception e) {
//                    System.out.println("Se ha producido un error inesperado. Por favor, contacte con el administrador.");
//                }
            }
    }

}
