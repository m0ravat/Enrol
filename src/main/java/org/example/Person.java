package org.example;

public class Person {
    private String firstname;
    private String surname;
    private String email;
    public Person(String firstname, String surname, String email){
        this.firstname=firstname;
        this.surname=surname;
        this.email=email;
    }
    public void setFname(String firstname){
        this.firstname=firstname;
    }
    public void setSname(String surname){
        this.surname=surname;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getFname(){
        return this.firstname;
    }
    public String getSname(){
        return this.surname;
    }
    public String getEmail(){
        return this.email;
    }
    public void printPerson(){
        System.out.println("org.example.Person name: " + this.firstname + " " + this.surname + " email: " + this.email);
    }
}
