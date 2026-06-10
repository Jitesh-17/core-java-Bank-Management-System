package main;

public class AccountService {

    private AccountRepository repository;
    

    public AccountService(AccountRepository repository){
        this.repository = repository;
    }
    private static long accountcounter = 1001;
    
    public Account createAccount(String holderName,double balance){
        
        String accountNumber = "ACC" + accountcounter++;

        Account account = new Account(
            accountNumber,
            holderName,
            balance
        );

        repository.saveAccount(account);
        return account;

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

    public double checkBalance(Account account){
        return account.getBalance();
    }

    public Account getAccount(String accountNumber){
       return repository.findAccount(accountNumber);
    }

    public void displayAllAccounts (){
        for( Account accounts : repository.getAllAccounts()){
            
            System.out.println("Account Number:"+accounts.getAccountNumber()+" "+"Account holder name:"+accounts.getHolderName()
            +" "+"Current Balance:"+accounts.getBalance());
            
        }
    }


}
