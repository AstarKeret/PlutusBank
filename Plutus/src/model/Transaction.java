package model;

import java.util.Date;

import transaction.AccountBoundary;

public class Transaction {
	private AccountBoundary source;
	private String comment;
	private Date timestamp;
	private double amount;
	
	public Transaction(AccountBoundary source, String comment, Date timestamp, double amount) {
		this.source = source;
		this.comment = comment;
		this.timestamp = timestamp;
		this.amount = amount;
	}
	
	public AccountBoundary getSource() {
		return source;
	}
	public void setSource(AccountBoundary source) {
		this.source = source;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
