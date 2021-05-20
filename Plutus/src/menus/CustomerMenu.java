package menus;
import java.util.Scanner;

import main.ManagmentSystem;
import model.Account;
import model.Customer;
import usecases.OpenAccount;
import usecases.ShowAccount;
import usecases.ShowCustomer;

public class CustomerMenu {


	static Account accountLogin;
	public static void run(Customer customer, String[] args)// After Login
	{
		boolean flag=false;	
		Scanner data = new Scanner(System.in);  // Create a Scanner object

		do {
			try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
				System.err.println("Welcome to Plutus Customer Menu\n");
				System.out.println("Select one of the displayed options and enter its number after the #\n");
				System.out.println("1. Show my data \n");// 1
				System.out.println("2. Show my accounts \n");// 2
				System.out.println("3. Open new account\n");// 3
				System.out.println("4. Select an account\n");// 4
				System.out.println("5. Logout\n");// 5
			try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
				System.err.print("#  ");
				
				int select = data.nextInt();  // select
				
				switch(select)
				{
				case (1):
					new	ShowCustomer().showCustomerInfo(customer); 
					break;
				case (2):
					new ShowAccount().show(customer);
					break;
				case (3):
					customer.addAllAccount(OpenAccount.openNewRequest());
					System.out.println("Open Account Succeeded");
					break;
				case (4):
					for(int i = 0 ; i < customer.getAllAccounts().size() ; i++)
						System.out.println((i+1)+".\t"+customer.getAllAccounts().get(i).getAccountNumber());
					
					System.out.println("Please enter your selection\n");// 4
					select = data.nextInt();
					try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
						System.err.print("#  ");
						accountLogin = customer.getAllAccounts().get(select);
						AccountMenu.run(accountLogin, args);			break;
					case (5):
					
					flag = true;
					break;
				}
		}while(!flag);
		data.close();
	}
	public static Account getAccountLogin() {
		return accountLogin;
	}
	public static void setAccountLogin(Account accountLogin) {
		CustomerMenu.accountLogin = accountLogin;
	}
}
