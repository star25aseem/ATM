import java.util.Random;
import java.util.Scanner;
//you have to deposit 500 per month per
public class RD extends Account {
    Scanner s=new Scanner(System.in);
    private int AMOUNT_DEPOSITED;
    public int getAMOUNT_DEPOSITED() {
        return AMOUNT_DEPOSITED;
    }
    public void setAMOUNT_DEPOSITED(int amount_deposit) {
        AMOUNT_DEPOSITED = amount_deposit;
    }
    protected int NUM_OF_YEARS;
    protected int Interest_rate;
    public void balance_display(int a){
      double Interest=this.AMOUNT_DEPOSITED*this.NUM_OF_YEARS*(2.3)/100;
      this.balance=this.AMOUNT_DEPOSITED+Interest;
      System.out.println("This "+" account "+" has "+this.balance+" amount");
    }
    public void create_Account(){
        Random r=new Random();
        this.Account_NUM=r.nextInt(100000);
        System.out.println("This is your account number for recurring deposit, remember it for future use");
        System.out.println(this.Account_NUM);
        int z=r.nextInt(100000);
        this.setPIN(z);
        System.out.println("This is your PIN for recurring deposit, remember it for future use");
        System.out.println(this.getPIN());
        System.out.println("Please enter the total amount you want to deposit in installations");
        this.AMOUNT_DEPOSITED=s.nextInt();
        System.out.println("Please enter the tenure of Reccuring deposit");
        this.NUM_OF_YEARS=s.nextInt();
    }
    public void dispense(){
        double Interest=this.AMOUNT_DEPOSITED*this.NUM_OF_YEARS*this.Interest_rate/100;
        this.balance=this.AMOUNT_DEPOSITED+Interest;
        System.out.println("you are provided with "+this.balance);
        this.balance=0;
    }
     //if person wants to break the rd before tenure completion.
    // here a is the number of years after the deposition.
    public void dispense(int a){
        double Interest=this.AMOUNT_DEPOSITED*this.NUM_OF_YEARS*(2.3)/100;
        this.balance=this.AMOUNT_DEPOSITED+Interest;
        System.out.println("you are provided with "+this.balance);
        this.balance=0;
    }
}
