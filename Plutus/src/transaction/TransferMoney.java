package transaction;

import java.util.Scanner;

import model.IDGenerator;

public class TransferMoney {
	public final static String MY_ID = "afeka08";
	public static void transfer(String[] args) {
		try (Scanner scanner = new Scanner(System.in)){
			System.err.println("Enter account number");
			String accountNumber = scanner.nextLine().trim();
			System.err.println("Enter bank ID");
			String bankID = scanner.nextLine().trim();
			System.err.println("Enter branch number");
			String branch = scanner.nextLine().trim();
			System.err.println("Enter reciver name");
			String name = scanner.nextLine().trim();
			System.err.println("type the amount:");
			double amount = scanner.nextDouble();
			System.err.println("type a commant:");
			String commant = scanner.nextLine().trim();
			
			AccountBoundary destination = new AccountBoundary(accountNumber, bankID, branch, name);
			AccountBoundary source = new AccountBoundary();
			BankingTransactionBoundary trans= new BankingTransactionBoundary(source, destination, commant, amount);
			//add function check amount
			try (TransactionSession ts = new TransactionSession(MY_ID, args)){
				ts.sendMoney(trans);
				System.err.println("type any key to quit");
			}catch (Exception e) {
				System.err.println("type any key to quit");
			}
			
		}		
	}
}
