package menus;
import java.util.Scanner;

import model.Account;
import transaction.TransferMoney;
import usecases.ShowAccount;

public class AccountMenu {
	
	static void run(Account accountLogin, String[] args)// After Login
	{
		boolean flag=false;	
		Scanner data = new Scanner(System.in);  // Create a Scanner object
		do {
		System.err.println("Welcome to Account " + accountLogin.getAccountNumber());
		System.out.println("Select one of the displayed options and enter its number after the #\n");
		System.out.println("1. Show my data \n");// 1
		System.out.println("2. Transaction \n");// 2
		System.out.println("3. Logout\n");// 3
		System.err.print("#  ");
		
		int select = data.nextInt();  // select
		
		switch(select)
		{
		case (1):
			new ShowAccount().showAccount(accountLogin);
			break;
		case (2):
			TransferMoney.transfer(args);
			break;
		case (3):
			flag=true;
			break;
		}
		}while(flag==false);
		data.close();
	}
}
