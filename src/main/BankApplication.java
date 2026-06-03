package main;

public class BankApplication {
    public static void main(String[] args){
       System.out.println("Welcome to Bank Management System"); 

       AccountService service = new AccountService();

       Account acc = service.createAccount("Acc1001","jitesh",10000);

      System.out.println("Congratulations! Bank account created successfully");
      System.out.println("Account Number : " + acc.getAccountNumber());
      System.out.println("Name : " + acc.getHolderName());
      System.out.println("Balance : " + acc.getBalance());
    }
}



 