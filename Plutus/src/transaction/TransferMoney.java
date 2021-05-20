package transaction;

import java.util.Scanner;

import main.Main;
import model.Account;
import model.Customer;

public class TransferMoney {
	public static Scanner scanner = new Scanner(System.in);
	public final static String MY_ID = "afeka08";

	public static void transfer(String[] args) {
		AccountBoundary destination = getDestinationDetails();
		double amount = -1;
		while(true){
			try {
			System.out.println("Amount to be transferred:");
			amount = scanner.nextDouble();
			if(amount <= 0)
				System.out.println("The amount to be transferred must be greater than 0");
			else
				break;
		}catch (Exception e) {
			System.out.println("The amount must be written in the digits");
			scanner.next();
		}
			}
		System.out.println("Enter a commant:");
//		scanner.nextLine();
		String commant = scanner.next().trim();
		new TransactionCtrl(args).sendMoney(destination, amount, commant);
	}
	

	
	private static AccountBoundary getDestinationDetails() {
		String accountNumber, bankID, branch, name;
		while(true){
			System.out.println("Enter account number");
			accountNumber = scanner.nextLine().trim();
			System.out.println("Enter bank ID");
			bankID = scanner.nextLine().trim();
			System.out.println("Enter branch number");
			branch = scanner.nextLine().trim();
			System.out.println("Enter reciver name");
			name = scanner.nextLine().trim();
			if(accountNumber.isBlank()) {
				System.out.println("You must enter an account number");
				continue;
			}
			if(bankID.isBlank())
				System.out.println("You must enter a bank ID");
			else
				break;
		}
		return new AccountBoundary(accountNumber, bankID, branch, name);
		
	}
}
