package com.sapient.Banking;

public class SavingAccount extends AbstractBankAccount {
		
	private double rate = 0.01;
	public SavingAccount(int acctnum) {
	super(acctnum);
	}
		@Override 
		public int maximumLoan() {
			return balance *2;
		}
		
		@Override 
		public String get_type() {
			return "Savings Account";
		}
	
		@Override
		public int hasEnoughCollateral(int loanamt) {
		return balance*2 - loanamt;
		}
		
		@Override
		public String toString() {
		String result = "Savings Account "+ acctnum+ " : balance=" + balance+ " ,is "+(isforeign?
		"foreign": "domestic");
		return result;
		}
		
		@Override
		public void addInterest() {
		this.balance += (int) (balance * rate);
		}
}

