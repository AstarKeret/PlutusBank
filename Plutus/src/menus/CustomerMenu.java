package menus;

import java.util.Scanner;

import model.Account;
import model.Customer;

public class CustomerMenu {
	static Account accountLogin;
	public static void run(Customer customer)// After Login
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
		System.out.println("4. Select an account\\n");// 4
		System.out.println("5. Logout\n");// 3
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		System.err.print("#  ");
		
		int select = data.nextInt();  // select
		
		switch(select)
		{
		case (1):
			//show customer
			break;
		case (2):
			// show accounts
			break;
		case (3):
			// open accounts
			break;
		case (4):
		int n=1;
		while(customer.getAllAccounts().iterator().hasNext())
		{
			System.out.println(n+"."+customer.getAllAccounts().iterator().next().getAccountNumber());
		}
		System.out.println("Please enter your selection\n");// 4
		select = data.nextInt();
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		System.err.print("#  ");
		AccountMenu.run(accountLogin);			break;
		case (5):
			
			flag=true;
			break;
		}
		}while(flag==false);
		data.close();
	}
}
