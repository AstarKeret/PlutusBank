package transaction;

import java.util.Scanner;

import model.Account;
import model.Customer;
import model.Main;

public class TransferMoney {
	public static Scanner scanner = new Scanner(System.in);
	public final static String MY_ID = "afeka08";

	public static void transfer(String[] args) {
		AccountBoundary destination = getDestinationDetails();
		double amount = 0;
		while(amount > 0){
			try {
			System.out.println("Amount to be transferred:");
		amount = scanner.nextDouble();
		}catch (Exception e) {
			System.out.println("a");
		}
			}
		System.out.println("Enter a commant:");
		String commant = scanner.nextLine().trim();
		scanner.next();
		new TransactionCtrl(args).sendMoney(destination, amount, commant);
	}
	

	
	private static AccountBoundary getDestinationDetails() {
		System.out.println("Enter account number");
		String accountNumber = scanner.nextLine().trim();
		System.out.println("Enter bank ID");
		String bankID = scanner.nextLine().trim();
		System.out.println("Enter branch number");
		String branch = scanner.nextLine().trim();
		System.out.println("Enter reciver name");
		String name = scanner.nextLine().trim();
		return new AccountBoundary(accountNumber, bankID, branch, name);
	}
}
//public static Boolean sendMoney(BankingTransactionBoundary trans) {
//try (TransactionSession ts = new TransactionSession(MY_ID, args)){
//
//	ts.sendMoney(trans);
//	System.err.println("type any key to quit");
//}catch (Exception e) {
//	System.err.println("type any key to quit");
//}
//return false;
//}

//Customer tmp = Main.getCustomer();
//AccountBoundary source = new AccountBoundary(Main.getAccount().getAccountNumber(), MY_ID, " ", tmp.getFirstName() + " " + tmp.getSurName());
//AccountBoundary destination = getDestinationDetails();
//
//System.err.println("Amount to be transferred:");
//double amount = scanner.nextDouble();
//System.err.println("Enter a commant:");
//String commant = scanner.nextLine().trim();
//BankingTransactionBoundary trans= new BankingTransactionBoundary(source, destination, commant, amount);
//try (TransactionSession ts = new TransactionSession(MY_ID, args)){
//
//	ts.sendMoney(trans);
//	System.err.println("type any key to quit");
//}catch (Exception e) {
//	System.err.println("type any key to quit");
//}
