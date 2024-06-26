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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean loop = false;
        while (!loop){
            System.out.println("Please select which class you want to enrol in: " +
                    "1 - Server side web development " +
                    "2 - Client side web development" +
                    "3 - Mobile App Development" +
                    "4 - Operating Systems" +
                    "5 - Robotic Principles" +
                    "0 - Quit Application");
            try {
                int menu = input.nextInt();
                switch (menu) {
                    case 1 -> current=serverWeb;
                    case 2 -> current=clientWeb;
                    case 3 -> current=mobile;
                    case 4 -> current=operate;
                    case 5 -> current=robots;
                    case 0 -> {
                        loop=true;
                        System.out.println("Thank you for using the Plane Management application");
                    }
                    default -> System.out.println("Please enter a valid menu option");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter an integer please");
                input.nextLine();
            }
            int x = 1;
            while (x==1){
                System.out.println("Would you like to: " +
                        "A - Book a place" +
                        "B - Cancel a place" +
                        "C - Find the first available place" +
                        "D - Find how many openings are left" +
                        "E - Find the info for a seat" +
                        "F - Return to the original menu" +
                        "G - Quit Application");
                String choice = input.next();
                int row = 0;
                int col = 0;
                switch (choice) {
                    case "A":
                        row = getRow();
                        col = getCol();
                        current.buySeat(row,col);
                    case "B":
                        row = getRow();
                        col = getCol();
                        current.cancelSeat(row,col);
                    case "C":
                        current.findFirstSeat();
                    case "D":
                        current.seatsLeft();
                    case "E":
                        row = getRow();
                        col = getCol();
                        current.seatInfo(row,col);
                    case "F":
                        x=2;
                    case "G":
                        x=2;
                        loop=true;
                        break;
                }
            }
        }
    }

    private static int getCol(){
        Scanner input = new Scanner(System.in);
        int col = 0;
        int maxcol = current.getSize();
        boolean colValid = false;
        while (!colValid){
            System.out.println("Enter a column number between 0 and " + maxcol);
            col = input.nextInt();
            if (col > -1){
                if (col < (maxcol+1)){
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
            System.out.println("Enter a column number between 0 and " + maxrow);
            row = input.nextInt();
            if (row > -1){
                if (row < (maxrow+1)){
                    rowValid = true;
                }
            }
        }
        return row;
    }

}