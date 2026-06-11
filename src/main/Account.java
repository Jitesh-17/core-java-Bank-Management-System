package main;
import java.util.*;
public class Account{
    final private String accountNumber;
    final  private String holderName;
    private double balance;

    public List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransaction(){
        return transactions;
    }

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
