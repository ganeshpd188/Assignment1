package com.sapient.Banking;

public abstract class AbstractBankAccount implements BankAccount {
	
	protected int acctnum;
	protected int balance = 0;
	protected boolean isforeign = false;
	private OwnerStrategy owner = new Domestic();
	
	public AbstractBankAccount(int acctnum) {
	this.acctnum = acctnum;
	}
	@Override
	public int getAcctnum() {
	return acctnum;
	}
	@Override
	public int getBalance() {
	return balance;
	}
	public void setBalance(int balance) {
	this.balance = balance;
	}
	/*@Override
	public int compareTo(BankAccount ba) {
	int bal1 = getBalance();
	int bal2 = ba.getBalance();
	if (bal1 == bal2)
	return getAcctnum() - ba.getAcctnum();
	else
	return bal1 - bal2;
	}*/
	/*@Override
	public boolean isIsforeign() {
	return isforeign;
	}
	@Override
	public void setIsforeign(boolean isforeign) {
	this.isforeign = isforeign;
	}*/
	@Override
	public boolean isIsforeign() {
	return isforeign;
	}
	@Override
	public void setIsforeign(boolean isforeign) {
	this.isforeign = isforeign;
	}
	@Override
	public void deposit(int amt) {
	this.balance +=amt;
	}
	/*@Override
	public boolean isIsforeign() {
	return owner.isForeign();
	}
	@Override
	public void setIsforeign(boolean isforeign) {
	owner = isforeign? new Foreign(): new Domestic();
	}*/

	@Override
	public String toString(){
	return  get_type()+" account "+ acctnum + ": balance="+balance + ", is "+	owner.toString();
	}
	
	public int fee(){
	return owner.fee();
	}
	@Override
	public abstract int hasEnoughCollateral(int loanamt);
	/*@Override
	public abstract String toString();*/
	public abstract void addInterest();	
	}
