package main;

public class BankApplication {
    public static void main(String[] args){
        System.out.println("Welcome to Bank Management System"); 

        AccountRepository repository = new AccountRepository();
        
        AccountService service = new AccountService(repository);

        BankMenu menu = new BankMenu(service);
        menu.start();

    //    Account acc = service.createAccount("Acc1001","jitesh",10000);
    //    System.out.println("Congratulations! Bank account created successfully");
    //    System.out.println("Account Number : " + acc.getAccountNumber());
    //    System.out.println("Name : " + acc.getHolderName());
    //    System.out.println("Balance : " + acc.getBalance());
      
    //    service.deposit(acc,5000);
    //    System.out.println("\nAmount Deposit successful! \nCurrent Amount : " + acc.getBalance());

    //     service.withdraw(acc,3000);
    //     System.out.println("\nAmount withdrawal successful! \nCurrent Amount : " + acc.getBalance());

    //     Account foundAccount = service.getAccount("Acc1001");
    //     System.out.println("account holder name:" + foundAccount.getHolderName());



    }
}



 