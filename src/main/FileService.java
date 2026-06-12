package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    

    public void saveAccount(Account account){
        try {
            FileWriter writer = new FileWriter("Accounts.txt",true);

            writer.write(
                account.getAccountNumber() +","+ account.getHolderName()+","+account.getBalance() + "\n"
            );

            writer.close();

        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }
     public List<Account> loadAccounts(){

        List<Account> accounts = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Accounts.txt"));

            String line ;
            while((line = reader.readLine()) != null) {
                 String[] data =
                    line.split(",");

                Account account =
                    new Account(
                            data[0],
                            data[1],
                            Double.parseDouble(
                                    data[2]));
                accounts.add(account);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("No accounts Found");
        }
        return accounts;
    }

    public void saveTransaction(String accountNumber,Transaction transaction){

        try {
            FileWriter writer = new FileWriter("Transaction.txt",true);

            writer.write(accountNumber+","+transaction.getType()+","+transaction.getAmount()+"\n");
            writer.close();

        } catch (Exception e) {
            System.out.println("Error Saving Transaction");
        }
    }

    public void loadTransactions(
        AccountRepository repository) {

    try {

        BufferedReader reader =
                new BufferedReader(
                        new FileReader(
                                "transactions.txt"));

        String line;

        while((line = reader.readLine())
                != null) {

            String[] data =
                    line.split(",");

            String accountNumber =
                    data[0];

            String type =
                    data[1];

            double amount =
                    Double.parseDouble(
                            data[2]);

            Account account =
                    repository.findAccount(
                            accountNumber);

            if(account != null) {

                Transaction transaction =
                        new Transaction(
                                type,
                                amount);

                account.getTransaction()
                       .add(transaction);
            }
        }

        reader.close();

    } catch(Exception e) {

        System.out.println(
                "No transactions found");
    }
}
}
