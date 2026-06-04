package main;

public class AccountService {
    
    public Account createAccount(String accountNumber,String holderName,double balance){
        

        return new Account(
            accountNumber,
            holderName,
            balance
        );

    }
}
