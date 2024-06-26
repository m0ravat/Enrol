import java.util.Scanner;

public class Module {
    private String subject;
    private int size;
    private String seats[][];
    private Person person;
    public Seat[] record;
    public Module(String subject, int size){
        this.subject = subject;
        this.size = size;
        genPerson();
        genSeats();
    }
    private void genPerson(){
        this.person.setEmail("Default");
        this.person.setFname("Default");
        this.person.setSname("Default");
    }
    private void genSeats(){
        this.seats = new String[4][size];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < size; j++){
                switch (i){
                    case 0:
                        this.seats[0][j] = "C1";
                    case 1:
                        this.seats[1][j] = "C2";
                    case 2:
                        this.seats[2][j] = "C3";
                    case 3:
                        this.seats[3][j] = "C4";
                }
            }
        }
    }
    public void setSubject( String subject ){this.subject = subject;}
    public void setSeats(int row, int col, String val){this.seats[row][col] = val;}
    public void setSize( int size ){this.size = size;}
    public void setPerson(String firstname, String surname, String email){
        person = new Person(firstname,surname,email);
    }

    public String getSubject(){return this.subject;}
    public int getSize(){return this.size;}
    public void getSeats(){
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " , ");
            }
        }
    }
    public Person getPerson(){return this.person;}

    public void buySeat(int row, int col){
        if(seats[row][col].equals("X")){System.out.println("Seat has been bought");}
        else{
            buy(row,col);
        }
    }
    private void buy(int Row, int col){
        this.seats[Row][col] = "X";
        PersonInfo();
        CreateRecord(Row,col);
    }
    private void CreateRecord(int row,int col){
        String Class = "";
        switch (row){
            case 0:
                Class = "C1";
            case 1:
                Class = "C2";
            case 2:
                Class = "C3";
            case 3:
                Class = "C4";
        }
        for (int x=0;x<4*size;x++){
            if (record[x] == null){
                record[x].setCol(col);
                record[x].setRow(row);
                record[x].setClasss(Class);
                record[x].setPerson(this.person);
                x = 1000;
            }
        }
    }
    private void PersonInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String fname = input.next();
        this.person.setFname(fname);
        System.out.println("Enter your surname: ");
        String sname = input.next();
        this.person.setSname(sname);
        System.out.println("Enter your email: ");
        String email = input.next();
        this.person.setEmail(email);
    }
    public void cancelSeat(int row, int col){
        setSeats(row, col, "C" + row);
        System.out.println("You have cancelled this module.");
        cancel(row,col);
        getSeats();
    }
    private void cancel(int row, int col){
        for (int x = 0;x<4*size;x++){
            if (row==record[x].getRow()){
                if (col == record[x].getCol()){
                    for (int y = x;y<record.length-1;y++){
                        record[y] = record[y+1];
                        x = 52;
                    }
                }
            }
        }
    }
    public void findFirstSeat(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.seats[i][j].contains("C")) {
                    System.out.println("First seat is available at " + i + " " + j);
                    i=4;
                    break;
                }
            }
        }
    }
    public void printSeats(){
        getSeats();
    }
    public void seatsLeft(){
        int total = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.seats[i][j].equals("O")) {
                    total++;
                }
            }
        }
        System.out.println("There are " + total + " seats left");
    }
    public void seatInfo(int row, int col){
        if (this.seats[row][col].contains("C")){
            System.out.println("Seat is available at " + row + " " + col);
        }
        else{
            for (int x =0;x<record.length-1;x++){
                if (record[x].getRow()==row){
                    if (record[x].getCol() == col){
                        record[x].printTicket();
                        x=1000;
                    }
                }
            }
        }
    }
}
