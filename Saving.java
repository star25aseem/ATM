import java.util.Random;

public class Saving extends Account{
    public void balance_display(int a){
        System.out.println("This "+" account "+" has "+this.balance+" amount");
    }
    public void create_Account(){
        Random r=new Random();
        this.Account_NUM=r.nextInt(100000);
        System.out.println("This is your account number, remember it for future use");
        System.out.println(this.Account_NUM);
        int z=r.nextInt(100000);
        this.setPIN(z);
        System.out.println("This is your PIN, remember it for future use");
        System.out.println(this.getPIN());
        System.out.println("We are providing you with initial Rs.1000 You have to maintain balance of atleast 1000 to maintain this account");
        this.balance=1000;
    }
    //here a is amount deposited
    //here c is months after which you used ATM service
    public void deposit(int a,int c){
        double Interest=this.balance*(c/12)*3/100;
        this.balance+=Interest;
        this.balance+=a;
        this.balance_display(c);
    }
    //here b is amount dispensed
    //here d is month after which you used ATM service
    public void dispense(int b,int d){
        double Interest=this.balance*(d/12)*3/100;
        this.balance+=Interest;
        if(this.balance>=b-1000){
        this.balance-=b;
        this.balance_display(d);
        }
        else{
            System.out.println("sorry you dont have enough amount");
        }
    }
}
