package main;
import java.util.*;
public class BankMenu{

   private AccountService service ;

    public BankMenu(AccountService service){
        this.service = service;
    }

    public void start(){

        Scanner sc= new Scanner(System.in);

        while (true) { 
            
            System.out.println("==== Bank Menu ====");
            System.out.println("press 1 to create account");
            System.out.println("press 2 to get your account details");
            System.out.println("Press 3 to Deposit Money");
            System.out.println("Press 4 to withdrawal");
            System.out.println("Press 5 to check balance");
            System.out.println("Press 6 to view Transaction History");
            System.out.println("Press 7 to exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter your name:");
                    String holderName = sc.nextLine();
                    System.out.println("Name Entered:"+ holderName);

                    System.out.println("Enter your initial balance:");
                    double balance = Double.parseDouble(sc.nextLine());
                    System.out.println("balance Entered:"+ balance);
                    
                    Account account = service.createAccount(holderName, balance);
                    
                    System.out.println("Account created succesfully");

                    System.out.println("Your account number:"+ account.getAccountNumber());
                    
                        break;
                
                case 2: System.out.println("Enter your account number");
                        String accountNumber = sc.nextLine();

                         account = service.getAccount(accountNumber);
                        if(account != null){
                            System.out.println("Account number :" +account.getAccountNumber());
                            System.out.println("Account holder name :" +account.getHolderName());
                            System.out.println("Current balance:"+account.getBalance());
                        }else{
                            System.out.println("Invalid account Number! \n Try again...");
                        }

                        break;
                case 3: System.out.println("Enter your account Number");
                        accountNumber = sc.nextLine();
                        account = service.getAccount(accountNumber);

                        if(account == null){
                            System.out.println("Account not found");
                            break;
                        }
                        System.out.println("Enter Deposit Amount:");
                        double amount = sc.nextDouble();
                        
                        try { 
                        service.deposit(account,amount);
                        System.out.println("Deposit Successful");

                        System.out.println("Updated Balance:"+ account.getBalance());
                        } 
                        catch(InvalidAmountException e){
                            System.out.println(e.getMessage());
                        }

                        break;
                case 4: System.out.println("Enter Your Account number");
                        accountNumber = sc.nextLine();
                        account = service.getAccount(accountNumber);

                        if(account==null){
                            System.out.println("Account not found");
                            break;
                        }
                        System.out.println("Enter the amount to be withdrawn");
                        amount = sc.nextDouble();
                        
                        try { 
                        service.withdraw(account, amount);
                        System.out.println("Withdrawal Succesful");

                        System.out.println("updated balance:"+ account.getBalance());
                        }
                        catch(InvalidAmountException e){
                            System.out.println(e.getMessage());
                        }
                        catch(InsufficientAmountException e){
                            System.out.println(e.getMessage());
                        }
                        
                        break;
                case 5:System.out.println("Enter Your Account number");
                        accountNumber = sc.nextLine();
                        account = service.getAccount(accountNumber);

                        if(account==null){
                            System.out.println("Account not found");
                            break;
                        }

                        System.out.println("Current Balance:"+ service.checkBalance(account));
                        break;
                case 6: System.out.println("Enter your Account Number");
                        accountNumber = sc.nextLine();
                        account = service.getAccount(accountNumber);

                        if(account==null){
                            System.out.println("Account not found");
                            break;
                        }
                        
                        service.showTransactionHistory(account);
                        break;
                        
                case 7:System.out.println("Thank You");
                        return;

                default:System.out.println("Invalid choice");    
                   
            }
            sc.close();
        }
    
    }
} 