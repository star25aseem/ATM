import java.util.Random;

public class Salary extends Account{
    public void balance_display(int a){
        this.balance-=500*a*12;
        System.out.println("This "+" account "+" has "+this.balance+" amount");
    }
    public void create_Account(){
        Random r=new Random();
        this.Account_NUM=r.nextInt(100000);
        System.out.println("This is your account number for salary account, remember it for future use");
        System.out.println(this.Account_NUM);
        int z=r.nextInt(100000);
        this.setPIN(z);
        System.out.println("This is your PIN for salary account , remember it for future use");
        System.out.println(this.getPIN());
    }
}
