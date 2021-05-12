package transaction;

import java.util.Scanner;

import model.Account;
import model.Customer;
import model.Main;
import model.TransactionCtrl;

public class TransferMoney {
	public static Scanner scanner = new Scanner(System.in);
	public final static String MY_ID = "afeka08";
	public static void transfer(String[] args) {
		AccountBoundary destination = getDestinationDetails();
		System.err.println("Amount to be transferred:");
		double amount = scanner.nextDouble();
		System.err.println("Enter a commant:");
		String commant = scanner.nextLine().trim();
		
		try (TransactionSession ts = new TransactionSession(MY_ID, args)){
		
		}catch (Exception e) {
			System.err.println("type any key to quit");
		}
		
//		Customer tmp = Main.getCustomer();
//		AccountBoundary source = new AccountBoundary(Main.getAccount().getAccountNumber(), MY_ID, " ", tmp.getFirstName() + " " + tmp.getSurName());


//		BankingTransactionBoundary trans= new BankingTransactionBoundary(source, destination, commant, amount);
//		try (TransactionSession ts = new TransactionSession(MY_ID, args)){
//		
//			ts.sendMoney(trans);
//			System.err.println("type any key to quit");
//		}catch (Exception e) {
//			System.err.println("type any key to quit");
//		}
	}
	private static AccountBoundary getDestinationDetails() {
		System.err.println("Enter account number");
		String accountNumber = scanner.nextLine().trim();
		System.err.println("Enter bank ID");
		String bankID = scanner.nextLine().trim();
		System.err.println("Enter branch number");
		String branch = scanner.nextLine().trim();
		System.err.println("Enter reciver name");
		String name = scanner.nextLine().trim();
		return new AccountBoundary(accountNumber, bankID, branch, name);
	}
}

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
