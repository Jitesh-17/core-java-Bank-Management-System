package main;

public class Account{
    final private String accountNumber;
    final  private String holderName;
    private double balance;

    public Account(String accountNumber,String holderName,double balance){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getHolderName(){
        return holderName;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }
    
}
