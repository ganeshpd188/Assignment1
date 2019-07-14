package com.sapient.Banking;

public class RegularCheckingAccount extends CheckingAccount {

	public RegularCheckingAccount(int acctnum) {
		super(acctnum);
		}
		/*@Override
		
		public String toString() {
		String result = "Checking Account "+ acctnum+ " : balance=" + balance+" ,is "+(isforeign? "foreign": "domestic");
		return result;
		}*/

		@Override
		public void addInterest() {
		}
}