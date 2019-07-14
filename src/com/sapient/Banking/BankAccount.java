package com.sapient.Banking;

public interface BankAccount {
		int maximumLoan();
		void setBalance(int balance);
		String get_type();
		int getAcctnum();
		int getBalance();
		boolean isIsforeign();
		void setIsforeign(boolean isforeign);
		void deposit(int amt);
		int hasEnoughCollateral(int loanamt);
		String toString();
		void addInterest();
		public int bankBalance();
}