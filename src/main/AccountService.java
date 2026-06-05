package main;

public class AccountService {
    
    public Account createAccount(String accountNumber,String holderName,double balance){
        

        return new Account(
            accountNumber,
            holderName,
            balance
        );

    }

    public void deposit(Account acc,double amount){
        if(amount<=0){
            System.out.println("invalid amount");
            return;
        }

        double updatedBalance = acc.getBalance()+amount;

        acc.setBalance(updatedBalance);
    }

    public void withdraw(Account acc,double amount){
        if(amount<=0){
            System.out.println("invalid amount");
            return;
        }

        if(amount>acc.getBalance()){
            System.out.println("insufficient balance");
            return;
        }
        double updatedBalance = acc.getBalance()-amount;

        acc.setBalance(updatedBalance);
    }
}
