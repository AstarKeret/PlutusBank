package chat;

import java.util.Scanner;

public class ChatApplication {
	public static void main(String[] args) {
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
			
			//add function check amount
			try (ChatSession u1 = new ChatSession(accountNumber, bankID, branch, name, args)){
				double message = scanner.nextDouble();
				u1.setAmount(message);
				System.err.println("type any key to quit");
			}catch (Exception e) {
				System.err.println("type any key to quit");
			}
			
		}		
		
	}
}
