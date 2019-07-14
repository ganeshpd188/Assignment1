package com.sapient.Banking;

public class CheckingAccount extends AbstractBankAccount {
	
	public CheckingAccount(int acctnum){
		super(acctnum);
		}
	
		@Override
		public int hasEnoughCollateral(int loanamt) {
		return (balance*3)/2-loanamt;
		}
	
	@Override
	public int maximumLoan() {
	   return (3*balance)/2; 	
	}
	
		@Override
		public String get_type() {
			return "Checking Account";
		}

		@Override
		public String toString() {
			String result = "Checking Account "+ acctnum+ " : balance=" + balance+
					" ,is "+(isforeign? "foreign": "domestic");
					return result;
				
		}

		@Override
		public void addInterest() {
			
		}
		
		
}