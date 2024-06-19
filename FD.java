import java.util.Random;
import java.util.Scanner;

public class FD extends Account{
    Scanner s=new Scanner(System.in);
    protected int NUM_OF_YEARS;
    private int AMOUNT_DEPOSITED;
    public int getAMOUNT_DEPOSITED() {
        return AMOUNT_DEPOSITED;
    }
    public void setAMOUNT_DEPOSITED(int aMOUNT_DEPOSITED) {
        AMOUNT_DEPOSITED = aMOUNT_DEPOSITED;
    }
    protected double Interest_rate;
    public void create_Account(){
        Random r=new Random();
        this.Account_NUM=r.nextInt(100000);
        System.out.println("This is your account number, remember it for future use");
        System.out.println(this.Account_NUM);
        int z=r.nextInt(100000);
        this.setPIN(z);
        System.out.println("This is your PIN, remember it for future use");
        System.out.println(this.getPIN());
        System.out.println("Please enter the amount of fixed deposit");
        this.AMOUNT_DEPOSITED=s.nextInt();
        System.out.println("Please Enter the tenure of your fixed deposit");
        this.NUM_OF_YEARS=s.nextInt();
    }
    public void dispense(){
        double Interest=this.AMOUNT_DEPOSITED*this.NUM_OF_YEARS*this.Interest_rate/100;
        this.balance=this.AMOUNT_DEPOSITED+Interest;
        System.out.println("you are provided with "+this.balance);
        this.balance=0;
    }
    //if person wants to break the fd before tenure completion.
    // here a is the number of years after the deposition.
    public void dispense(int a){
        double Interest=this.AMOUNT_DEPOSITED*this.NUM_OF_YEARS*(2.5)/100;
        this.balance=this.AMOUNT_DEPOSITED+Interest;
        System.out.println("you are provided with "+this.balance);
        this.balance=0;
    }
    public void balance_display(int a){
        System.out.println("This "+" account "+" has "+this.balance+" amount ");

    }
}
