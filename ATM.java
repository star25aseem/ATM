import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Random;

public class ATM extends Account {
  ArrayList<Saving>Saving_Account_list=new ArrayList<>();
  ArrayList<Salary>Salary_Account_list=new ArrayList<>();
  ArrayList<FD>FD_Account_list=new ArrayList<>();
  ArrayList<RD>RD_Account_list=new ArrayList<>();
  Scanner s=new Scanner(System.in);
  public void create_Account(){
  System.out.println("Please Enter the Account Type");
  String a=s.next();
  if(a.equalsIgnoreCase("fd")){
    FD A=new FD();
    A.create_Account();
    if(A.NUM_OF_YEARS>=8){
      A.Interest_rate=5;
    }
    else{
      A.Interest_rate=4;
    }
    FD_Account_list.add(A);
  }
  if(a.equalsIgnoreCase("rd")){
    RD A=new RD();
    A.create_Account();
    System.out.println("As for this service salary account is needed we are creating that as well for you");
    Salary B=new Salary();
    B.create_Account();
    RD_Account_list.add(A);
    Salary_Account_list.add(B);
  }
  if(a.equalsIgnoreCase("saving")){
    Saving A=new Saving();
    A.create_Account();
    Saving_Account_list.add(A);
  }
  if(a.equalsIgnoreCase("salary")){
    Salary A=new Salary();
    A.create_Account();
    System.out.println("You should create a RD account as well");
    RD B=new RD();
    B.create_Account();
    RD_Account_list.add(B);
    Salary_Account_list.add(A);
    }
  }
  //here a is months after which you accesed this function
  public void balance_display(int a){
    System.out.println("This "+" Account "+" has "+this.balance+" amount");
  } 
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    ATM my=new ATM();
    System.out.println("Welcome to our ATM services");
    System.out.println("If you want to create an account please type YES else type NO");
    String w=s.next();
    if(w.equalsIgnoreCase("yes")){
      my.create_Account();
      System.out.println("you account is created now please use our atm service");
    }
    while(true){
      Screen S=new Screen();
      S.start();
      synchronized(S){
      try{
        S.wait();
      }
      catch(InterruptedException e){
        e.printStackTrace();
      }
      int b=S.getEntered_PIN();
      for(int i=0;i<my.Saving_Account_list.size();i++){
        int a=my.Saving_Account_list.get(i).getPIN();
        if(my.Saving_Account_list.get(i).Account_NUM==S.Entered_Account_NUM && a==b){
          System.out.println("please type deposit if you want to deposit cash else NO");
          String e=s.next();
          if(e.equalsIgnoreCase("deposit")){
            System.out.println("Please enter the amount you want to deposit");
            int d=s.nextInt();
            System.out.println("Please enter the months after which you used our service");
            int m=s.nextInt();
            my.Saving_Account_list.get(i).deposit(d,m);
          }
          System.out.println("Please type dispence if you want to collect cash from your account else NO");
          String f=s.next();
          if(f.equalsIgnoreCase("dispence")){
            System.out.println("Please enter the amount you want to dispence");
            int amount=s.nextInt();
            System.out.println("Please enter the months after which you used our service");
            int month=s.nextInt(a);
            my.Saving_Account_list.get(i).dispense(amount,month);
          }

        break;
        }
      }
      for(int i=0;i<my.Salary_Account_list.size();i++){
        int a=my.Salary_Account_list.get(i).getPIN();
        if(my.Salary_Account_list.get(i).Account_NUM==S.Entered_Account_NUM && a==b){
          System.out.println("please type deposit if you want to deposit cash else NO");
          String e=s.next();
          if(e.equalsIgnoreCase("deposit")){
            System.out.println("Please enter the amount you want to deposit");
            int d=s.nextInt();
            my.Salary_Account_list.get(i).deposit(d);
          }
          System.out.println("Please type dispence if you want to collect cash from your account else NO");
          String f=s.next();
          if(f.equalsIgnoreCase("dispence")){
            System.out.println("Please enter the amount you want to dispence");
            int amount=s.nextInt();
            my.Salary_Account_list.get(i).dispense(amount);
          }
          break;
        }
      }
      for(int i=0;i<my.RD_Account_list.size();i++){
        int a=my.RD_Account_list.get(i).getPIN();
        if(my.RD_Account_list.get(i).Account_NUM==S.Entered_Account_NUM && a==b){
          System.out.println("if your tenure is completed Type Completd");
          String q=s.next();
          if(q.equalsIgnoreCase("completed")){
            my.RD_Account_list.get(i).dispense();
            break;
          }
          System.out.println("if you want premature breaking type yes");
          String r=s.next();
          if(r.equalsIgnoreCase("yes")){
            System.out.println("please enter the no. of years after the year of deposition");
            int y=s.nextInt();
            my.RD_Account_list.get(i).dispense(y);
            break;
          }
        }
                    
      }
        for(int i=0;i<my.FD_Account_list.size();i++){
          int a=my.FD_Account_list.get(i).getPIN();
          if(my.FD_Account_list.get(i).Account_NUM==S.Entered_Account_NUM && a==b){
            System.out.println("if your tenure is completed Type Completd");
            String q=s.next();
            if(q.equalsIgnoreCase("completed")){
              my.FD_Account_list.get(i).dispense();
              break;
            }
            System.out.println("if you want premature breaking type yes");
            String r=s.next();
            if(r.equalsIgnoreCase("yes")){
              System.out.println("please enter the no. of years after the year of deposition");
              int y=s.nextInt();
              my.FD_Account_list.get(i).dispense(y);
              break;
            }
          }
                    
        }
      }
      System.out.println("type exit if you want to leave ELSE TYPE NO");
      String h=s.next();
      if(h.equals("exit")){
        break;
      }
    } 
  }

}
  