package com.sapient.Banking;

public class InterestCheckingAccount extends AbstractBankAccount {
	
	private double rate = 0.01;
	public InterestCheckingAccount(int acctnum) {
	super(acctnum);
	}
	
	@Override
	public String toString() {
	return "Interest Checking Account " + getAcctnum()+ ":	balance="+getBalance()+ ", is "+(isIsforeign()? "foreign": "domestic");
	}
	
	@Override
	public void addInterest() {
	int balance = (int) (getBalance() * rate);
	deposit(balance);
	}
       
       
       @Override 
		public int maximumLoan() {
			return (3*balance)/2 ;
		}
       
       @Override
		public String get_type() {
			return "Interest Checking Account";
		}

	@Override
	public int hasEnoughCollateral(int loanamt) {
		return (3*balance)/2 - loanamt;
	}
    
}

