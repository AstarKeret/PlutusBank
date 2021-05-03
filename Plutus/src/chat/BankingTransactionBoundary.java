package chat;

import java.time.LocalDate;

public class BankingTransactionBoundary {
	private AccountBoundary source;
	private AccountBoundary destination;
	private String comment;
	private LocalDate timeStamp;
	private double amount;
	
	public AccountBoundary getSource() {
		return source;
	}
	public void setSource(AccountBoundary source) {
		this.source = source;
	}
	public AccountBoundary getDestination() {
		return destination;
	}
	public void setDestination(AccountBoundary destination) {
		this.destination = destination;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDate getDateStamp() {
		return timeStamp;
	}
	public void setDateStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
