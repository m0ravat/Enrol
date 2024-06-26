package org.example;

public class Seat {
    private int row;
    private int col;
    private String classs;
    private Person person;
    private int c;
    public Seat(int row, int col,String classs, Person person){
        this.row=row;
        this.col=col;
        this.classs=classs;
        this.person = person;
    }
    public void setRow(int row){
        this.row=row;
    }
    public void setCol(int col){
        this.col=col;
    }
    public void setClasss(String classs){this.classs=classs;}
    public void setPerson(String firstname, String surname, String email){
        person = new Person(firstname,surname,email);
    }
    public void setPerson(Person person){this.person=person;}
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public String getClasss(){return this.classs;}
    public Person getPerson(){
        return this.person;
    }
    public void printTicket(){
        System.out.println("Row is: " + this.row);
        System.out.println("org.example.Seat is: " + this.col);
        System.out.println("Class is: " + this.classs);
        person.printPerson();
    }
}

