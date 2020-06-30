/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankhashmap;

/**
 *
 * @author sahni
 */
import java.util.*;
public class BankHashMap {

    /**
     * @param args the command line arguments
     */
    public static void insertDetails(HashMap<String,Double> details)
  {
	  Scanner sc=new Scanner(System.in);
	  int choice;
	  do {
		  System.out.println("Enter the Customer name:");
		  String name = sc.next();
		  System.out.println("Enter the Account Balance:");
		  double balance = sc.nextDouble();
		  details.put(name, balance);
		 System.out.println("Press 0 to stop or any number to insert more products:");
		  choice = sc.nextInt();
	  }while (choice!=0);
  }
    public static void depositMoney(HashMap<String,Double> details)
    { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the customer name:");
	 String custName = sc.next();
	 if(details.get(custName)!=null)
         {
             System.out.println("Enter the amount to add to Prevailing Balance : ");
             double amount = sc.nextDouble();
             double total = details.get(custName) + amount;
             System.out.println("The new balance is: " + total + "added to "+custName+" account");
         }
         else
         {
             System.out.println("There is existing customer with this name");
         }
    }
    
    public static void withdrawMoney(HashMap<String,Double> details)
    { 
        double total = 0;
        double amount = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the customer name:");
	 String custName = sc.next();
	 if(details.get(custName)!=null)
         {
             System.out.println("Enter the amount to withdraw from Prevailing Balance : ");
             amount = sc.nextDouble();
             total = details.get(custName) - amount;
             System.out.println("The new balance is: " + total + " after withdraw from "+custName+" account");
         }
         else if(amount > details.get(custName))
         {
             System.out.println("Insufficient Balance to Withdraw the Amount.");
         }
         else
         {
             System.out.println("There is no existing customer with this name");
         }
    }
    
    public static void transferMoney(HashMap<String,Double> details)
    {
        double transferred = 0;
        double amount = 0;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer Name: ");
        String custName = sc.next();
        if(details.get(custName)!=null)
        {
            System.out.println("Enter the amount to be Transfered from Balance : ");
            amount = sc.nextDouble();
            double leftbalance = details.get(custName) - amount;
            System.out.println("Enter the name of customer to transfer Money :");
            String custName2 = sc.next();
            if(details.get(custName2)!=null)
            {
                transferred = details.get(custName2) + amount;
                System.out.println("The new balance is: " + transferred + " in name of "+custName2+" account");
            }
            else
         {
             System.out.println("There is no existing customer with this name");
         }
            System.out.println("The new balance is: " + leftbalance + " after transfer from "+custName+" account");
        }
        else
         {
             System.out.println("There is no existing customer with this name");
         }
    }
    
   public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
 //Creating Hashmap to insert details
        
        HashMap<String,Double>details = new HashMap<>();
	  insertDetails(details);
	  System.out.println(details);
          
          System.out.println("1. Balance Enquiry");
          System.out.println("2. Deposit Amount");
          System.out.println("3. withdraw Amount");
          System.out.println("4. Transfer Funds");
          System.out.println("0. Exit \t");
          
          System.out.println("Select any one function by pressing the number : ");
          int n = sc.nextInt();
// 1) Balance Enquiry by Name
          switch(n)
          {
              case 1:
                System.out.println("Enter the customer name:");
                String custName = sc.next();
                if(details.get(custName)!=null)
                    System.out.println("The account Holder is : " + custName + " having account balance: "+details.get(custName));
                else
                    System.out.println("Sorry there is no account holder with the entered name in database");
                break;
// 2) Depositing the amount with account holder
              case 2:
                depositMoney(details);
                break;
    
// 3) Withdrawing Amount from the account
              case 3:
                  withdrawMoney(details);
                  break;
     
// 4) Transfer Funds from customer accounts
              case 4:
                  transferMoney(details);
                  break;
             
// 5) Exit
              case 0:
                  System.out.println("Thank you for banking with us!! Have a Good Day.");
                  break;
    }
    }
    
}
