import java.util.Scanner;

public class Screen extends Thread {
    public int Entered_Account_NUM;
    private int Entered_PIN;
    public int getEntered_PIN() {
        return Entered_PIN;
    }
      public void setEntered_PIN(int entered_PIN) {
        Entered_PIN = entered_PIN;
       }
     public static int NUM_OF_WRONG_ATTEMPTS;
     Scanner s=new Scanner(System.in);
     public void run(){
     synchronized(this){
       System.out.println("Please Enter your 5-digit Account no.");
       this.Entered_Account_NUM=s.nextInt();
       System.out.println("Please enter your 5-digit pin");
       int c=s.nextInt();
       this.setEntered_PIN(c);
       notify();
      }
   }
}
