package model;

import java.util.Date;

public class Account {
	private String accountNumber;
	private double balance;
	private Date openDate;
	IDGenerator d = IDGenerator.getInstance(1);

	public Account(double balance) {
		this.balance = balance;
		accountNumber = "" + d.nextId();
		openDate = new Date();
	}
	public Account() {
		this(0);
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	
}
