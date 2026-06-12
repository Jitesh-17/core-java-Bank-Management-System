package main;
import java.util.*;

public class AccountRepository {
    
    private Map<String,Account> accounts = new HashMap<>();

    public void saveAccount(Account account){
        accounts.put (account.getAccountNumber(),account);
    }

    public Account findAccount(String accountNumber){
        // if(!accounts.containsKey(accountNumber)){
        //     System.out.println("invalid account number");
        //     return ;
        // }
        return accounts.get(accountNumber);
    }

    public Collection<Account> getAllAccounts(){
        return accounts.values();
    }

    public void saveLoadedAccount(Account account){
            accounts.put(account.getAccountNumber(),account);
    }
}
