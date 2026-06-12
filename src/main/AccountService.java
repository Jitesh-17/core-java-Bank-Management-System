package main;

import java.util.List;

public class AccountService {

    //fileservice object
    private FileService fileService = new FileService();


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
        fileService.saveAccount(account);
        
        return account;

    }

    public void deposit(Account acc,double amount){
        if(amount<=0){
            throw new InvalidAmountException("Invalid Amount");
        }

        double updatedBalance = acc.getBalance()+amount;

        acc.setBalance(updatedBalance);

        Transaction transaction = new Transaction("Deposit", amount);

        acc.getTransaction().add(transaction);

        fileService.saveTransaction(acc.getAccountNumber(), transaction);
    }

    public void withdraw(Account acc,double amount){
        if(amount<=0){
            throw new InvalidAmountException("Invalid Amount");
        }

        if(amount>acc.getBalance()){
            throw new InsufficientAmountException("Insufficient balance");
        }
        double updatedBalance = acc.getBalance()-amount;

        acc.setBalance(updatedBalance);

        Transaction transaction = new Transaction("withdraw",amount);

        acc.getTransaction().add(transaction);
        
        fileService.saveTransaction(acc.getAccountNumber(), transaction);
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

    public void showTransactionHistory(Account account){

        for (Transaction transaction : account.getTransaction()){
            System.out.println(transaction.getType() + " " + transaction.getAmount());
        }
    }

    public void loadAccounts(){

        List<Account> loadedAccounts= fileService.loadAccounts();
        for(Account accounts : loadedAccounts ){
            repository.saveLoadedAccount(accounts);
        }
    }

    public void loadTransactions(){
        fileService.loadTransactions(repository);
    }

    
}
