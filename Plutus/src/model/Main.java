package model;
import transaction.TransferMoney;

public class Main {

	private static Customer customer;
	private static Account account;
	
	public static void main(String[] args) {
	//	TransferMoney.transfer(args);
	}
	
	public static Customer getCustomer() {
		return customer;
	}
	
	public static Account getAccount() {
		return account;
	}
}
