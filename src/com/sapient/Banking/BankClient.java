package com.sapient.Banking;

import java.util.*;
public class BankClient {
     
	public BankClient(Scanner scanner, Bank bank) {
		this.scanner = scanner;
		this.bank = bank;
		}
	 private int current = -1;
     private Scanner scanner = new Scanner(System.in);
     private boolean done = false;
     private Bank bank = new Bank();
     
     public void run() {
    	 scanner = new Scanner(System.in);
    	 while(!done){
    	 System.out.print("Enter command (0= quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest 7=setforeign 8=current bank balance): ");
    	 int cmd = scanner.nextInt();
    	 processCommand(cmd);
    	 }
    	}
      
     private void select() {
        System.out.print("Enter acct#: ");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account "+ current + " is " + balance + " and type is " + bank.get_Type(current) );
     }
     
     private void deposit() {
    	 System.out.println("Enter the account number :");
    	 int accounter = scanner.nextInt();
         System.out.print("Enter deposit amt: ");
         int amt = scanner.nextInt();
         bank.deposit(accounter, amt);
     }
     
     private void authorizeLoan() {
    	 System.out.println("Enter the account number :");
    	 int accounter = scanner.nextInt();
         System.out.print("Enter loan amt: ");
         int loanamt = scanner.nextInt();
         if (bank.authorizeLoan(accounter, loanamt)>=0)
           System.out.println("Your loan is approved");
         else
           {
        	 System.out.print("Your loan is denied.");
        	 System.out.println(" You must have "+ Math.abs(bank.authorizeLoan(accounter, loanamt))+" more rupees to get loan approval");
        	 System.out.println(" The maximum loan that can be approved to you for now is Rs : "+ bank.maximumLoan(accounter));
           }
     } 
     
     private void showAll() {
    	 System.out.println(bank.toString());
    	}
     
     private void addInterest() {
    	 bank.addInterest();
       }
     
     private void setForeign() {
    	 System.out.println("Enter the account number :");
    	 int accounter = scanner.nextInt();
    	 bank.setForeign(accounter, true);
    	 }
     
    private boolean requestForeign() {
    	 System.out.println("Enter 1 for foreign, 2 for domestic: ");
    	 int val = scanner.nextInt();
    	 return val==1;
    	 }
    
    private void newAccount() {
    	boolean isforeign = requestForeign();
    	int type = requestForAccountType();
    	current = bank.newAccount(isforeign, type);
    	System.out.println("Your new account number is "+ current);
      }
    
    private int requestForAccountType() {
    	System.out.println("Enter 1 for Savings, 2 for Checking, 3 for MoneyMarket, 4 for InterestChecking: ");
    	int val = scanner.nextInt();
    	return val;
    }
     
    private void displayBalance() {
    	System.out.println("The current Bank Balance is : "+ bank.bankBalance());
    }
    private void quit() {
    	 done = true;
    	 System.out.println("Goodbye!...");
    	}
     
    private void processCommand(int cmd) {
    	
    	 switch (cmd){
            	 case 0:
    	           quit();
    	           done = true;
    	           return;
    	         case 1:
    	           newAccount();
    	           return;
    	         case 2:
    	           select();
    	           return;
    	         case 3:
    	           deposit();
    	           return;
    	         case 4:
    	           authorizeLoan();
    	           return;
    	         case 5:
    	           showAll();
    	           return;
    	         case 6:
    	           addInterest();
    	           return;
    	         case 7:
    	        	 setForeign();
    	        	 return;
    	         case 8:
    	        	 displayBalance();
    	        	 return;
    	 }
   	}
 
 }
