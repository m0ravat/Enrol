package org.example;

import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    static Module serverWeb = new Module("ServerSideWeb", 10);
    static Module clientWeb = new Module("ClientSideWeb", 5);
    static Module mobile = new Module("MobileAppDev", 10);
    static Module operate = new Module("OperatingSystems", 7);
    static Module robots = new Module("Robotics", 6);
    static Module current = serverWeb;
    public static int menu = 1;

    private static int getCol(){
        Scanner input = new Scanner(System.in);
        int col = 0;
        int maxcol = current.getSize();
        boolean colValid = false;
        while (!colValid){
            System.out.println("Enter a column number between 0 and " + (maxcol-1));
            col = input.nextInt();
            if (col > -1){
                if (col < maxcol){
                    colValid = true;
                }
            }
        }
        return col;
    }
    private static int getRow(){
        Scanner input = new Scanner(System.in);
        int row = 0;
        int maxrow = 4;
        boolean rowValid = false;
        while (!rowValid){
            System.out.println("Enter a row number between 0 and " + 3);
            row = input.nextInt();
            if (row > -1){
                if (row < (maxrow)){
                    rowValid = true;
                }
            }
        }
        return row;
    }


    public static void menu1(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please select which class you want to enrol in\n " +
                "1 - Server side web development\n " +
                "2 - Client side web development\n" +
                "3 - Mobile App Development\n" +
                "4 - Operating Systems\n" +
                "5 - Robotic Principles\n" +
                "0 - Quit Application\n");
        try {
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    current = serverWeb;
                    menu = 2;
                }
                case 2 -> {
                    current=clientWeb;
                    menu = 2;
                }
                case 3 -> {
                    current = mobile;
                    menu = 2;
                }
                case 4 -> {
                    current = operate;
                    menu = 2;
                }
                case 5 -> {
                    current = robots;
                    menu = 2;
                }
                case 0 -> {
                    menu=3;
                    System.out.println("Thank you for using the Plane Management application");
                }
                default -> System.out.println("Please enter a valid menu option");
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter an integer please");
            input.nextLine();
        }
    }
    public static void menu2(){
        current.getSeats();
        System.out.println("\n");
        Scanner input = new Scanner(System.in);
        int x;
        System.out.println("Would you like to: \n " +
                "A - Book a place\n" +
                "B - Cancel a place\n" +
                "C - Find the first available place\n" +
                "D - Find how many openings are left\n" +
                "E - Find the info for a seat\n" +
                "F - Return to the original menu\n" +
                "G - Quit Application");
        String choice = input.next();
        int row = 0;
        int col = 0;
        switch (choice) {
            case "A":
                row = getRow();
                col = getCol();
                current.buySeat(row,col);
                break;
            case "B":
                row = getRow();
                col = getCol();
                current.cancelSeat(row,col);
                break;
            case "C":
                current.findFirstSeat();
                break;
            case "D":
                current.seatsLeft();
                break;
            case "E":
                row = getRow();
                col = getCol();
                current.seatInfo(row,col);
                break;
            case "F":
                menu=1;
                break;
            case "G":
                menu=3;
                break;
        }
    }
    public static void main(String[] args) {
        boolean loop = true;
        while (loop == true) {
            if (menu == 1) {
                menu1();
            } else if (menu == 2) {
                menu2();
            } else {
                loop = false;
            }
        }
    }

}


