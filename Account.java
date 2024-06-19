public abstract class Account implements Hardware_implementation {
    public int Account_NUM;
    private int PIN;
    protected double balance;
    public int getPIN() {
        return PIN;
    }
    public void setPIN(int pIN) {
        PIN = pIN;
    }
    // a is number of months after which display is used
    abstract public void balance_display(int a);
    abstract void create_Account();
    //here a is amount deposited
    public void deposit(int a){
      this.balance+=a;
       
    }
    //here a is amount dispensed
    public void dispense(int b){
        if(this.balance>=b){
         this.balance-=b;
        }
        else{
            System.out.println("you dont have enough balance");
        }
    }
}
