package com.sapient.Banking;

public class MoneyMarketAccount extends AbstractBankAccount {
		
	private double rate = 0.02;
	public MoneyMarketAccount(int acctnum) {
	super(acctnum);
	}
		@Override 
		public int maximumLoan() {
			return balance *3;
		}
		
		@Override 
		public String get_type() {
			return "Money Market Account";
		}
	
		@Override
		public int hasEnoughCollateral(int loanamt) {
		return balance*3 - loanamt;
		}
		
		@Override
		public String toString() {
		String result = "Money Market Account "+ acctnum+ " : balance=" + balance+ " ,is "+(isforeign?
		"foreign": "domestic");
		return result;
		}
		
		@Override
		public void addInterest() {
		this.balance += (int) (balance * rate);
		}
		}