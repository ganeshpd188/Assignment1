package com.sapient.Banking;

import java.util.*;

  public class Bank {
       private Map<Integer, BankAccount> accounts = new HashMap<>();
       //private double rate = 0.01;
       private int nextacct = 0;
   
       public int newAccount(boolean isforeign, int type){
    	   int acctnum = nextacct++;
    	   BankAccount ba;
    	   if(type ==1)
    	      ba = new SavingAccount(acctnum);
    	   else if(type==2)
    	       ba = new CheckingAccount(acctnum);
    	   else if(type==3)
    		   ba = new MoneyMarketAccount(acctnum);
    	   else 
    		   ba = new InterestCheckingAccount(acctnum);
    	   ba.setIsforeign(isforeign);
    	   accounts.put(acctnum, ba);
    	   return acctnum;
    	 }
	 
       public int getBalance(int acctnum){	
    	   BankAccount ba = accounts.get(acctnum);
    	   return ba.getBalance();
       	}
       
       
       public void deposit(int acctnum, int amt){
    	   BankAccount ba = accounts.get(acctnum);
    	   int balance = ba.getBalance();
    	   ba.setBalance(balance+ amt);
       	}
       
       public void setForeign(int acctnum, boolean isforeign){
    	   BankAccount ba = accounts.get(acctnum);
    	   ba.setIsforeign(isforeign);
        }
       
       public int authorizeLoan(int acctnum, int loanamt){
    	   BankAccount ba = accounts.get(acctnum);
    	   return ba.hasEnoughCollateral(loanamt);
        }
       
       public int maximumLoan(int acctnum) {
    	   BankAccount ba=accounts.get(acctnum);
    	   return ba.maximumLoan();
       }
       public String toString() {
    	   String result = "The bank has "+ accounts.size()+ " accounts.";
    	   for (BankAccount ba: accounts.values())
    	   result += "\n\t"+ ba.toString();
    	   return result;
    	}
      
       public String get_Type(int acctnum) {
    	    BankAccount ba = accounts.get(acctnum); 
    	    String result = ba.get_type(); 
    	    return result;
       }
       
       public void addInterest() {
    	   for (BankAccount ba: accounts.values()){
    	   if(ba instanceof SavingAccount){
    	      SavingAccount sa = (SavingAccount)ba;
    	      sa.addInterest();
    	    }
    	   else if(ba instanceof MoneyMarketAccount) {
    		   MoneyMarketAccount ma = (MoneyMarketAccount)ba;
    		   ma.addInterest();
    	   }
    	   else if(ba instanceof InterestCheckingAccount) {
    		   InterestCheckingAccount ia = (InterestCheckingAccount)ba;
    		   ia.addInterest();
    	   }
    	  }
       }
       
       //to display the total bank balance 
       public int bankBalance() {
    	   int totalBalance = 0;
    	   for (BankAccount ba : accounts.values()) {
    		   totalBalance+=ba.getBalance();
    	   }
    	   return totalBalance;
       }
} 
