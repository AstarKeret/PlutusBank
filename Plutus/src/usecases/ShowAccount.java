package usecases;

import java.util.*;

import main.ManagmentSystem;
import model.Account;
import model.Customer;
import model.Employee;
import model.Person;
import model.Transaction;
import transaction.AccountBoundary;

public class ShowAccount {
	public final String BANK_ID = "afeka08";
	public void showAccount(Account account) {
		try {
			System.out.println("Total balance- " + account.getBalance());
			System.out.println("Opened on- " + account.getOpenDate().toString());
			if(account.getTransactions().size() > 0) 
				System.out.println("All account transactions: ");
			 for (int i = 0; i < account.getTransactions().size(); i++) {
				 Transaction getTransaction= account.getTransactions().get(i);
				 showTransaction(getTransaction, account);
			 }
		} catch (Exception e) {
			System.err.println("There is no such account");
		}

	}
	public void showTransaction(Transaction trans,Account account) {
		if(trans.getAmount()<0) {
			System.out.println("Transaction source:");
			System.out.println("BankId- " + BANK_ID);
			System.out.println("Account-"+ account.getAccountNumber());
			
			System.out.println("Transaction destination:");
			showAccontBoundary(trans.getOtherPerson());
		}
		else  {
			System.out.println("Transaction source:");
			showAccontBoundary(trans.getOtherPerson());
			
			System.out.println("Transaction destination:");
			System.out.println("BankId- " + BANK_ID);
			System.out.println("Account-"+ account.getAccountNumber());
			
		}
			
		System.out.println("Transaction amount- " + trans.getAmount());
		System.out.println("Comment-" + trans.getComment());
		System.out.println("Transation date:" + trans.getTimestamp());
	
	}
	public void showAccontBoundary(AccountBoundary boundary) {
		System.out.println("Account number- " + boundary.getAccountNumber());
		System.out.println("BankID" + boundary.getBankID());
		
	}

	public Account searchAccount(String accountNum, Object o) {
		ManagmentSystem manage = ManagmentSystem.getManager();
		if (o instanceof Employee) {
			for (int i = 0; i < manage.getAllCustomer().size(); i++) {
				for (int j = 0; j < manage.getAllCustomer().get(i).getAllAccounts().size(); j++) {
					if (accountNum.equals(manage.getAllCustomer().get(i).getAllAccounts().get(j).getAccountNumber()))
						return manage.getAllCustomer().get(i).getAllAccounts().get(j);

				}
			}
		} else {
			Customer c = (Customer) o;
			for (int i = 0; i < c.getAllAccounts().size(); i++) {
				if (c.getAllAccounts().get(i).getAccountNumber().equals(accountNum))
					return c.getAllAccounts().get(i);
			}
			
		}

		return null;
	}

	public void show(Person o) {//primaryMethod
		try {
			Scanner s = new Scanner(System.in);
			if (o instanceof Employee) {

				System.out.println("Please enter account number to display");
				String accountNum = s.next();
				showAccount(searchAccount(accountNum, o));

			} else {
				String choice = "";
				Customer c = (Customer) o;
				if (c.getAllAccounts().size() > 1) {
					System.out.println("You have multiple accounts, the accounts numbers are: ");
					for (int i = 0; i < c.getAllAccounts().size(); i++) {
						System.out.println("Account number: " + c.getAllAccounts().get(i).getAccountNumber());
					}

					do {
						System.out.println("please type the number of the account you show");
						String accountNum = s.next();
						showAccount(searchAccount(accountNum, o));
						System.out.println("Do you want to display another account? y/n");
						choice = s.next();

					} while (choice.equalsIgnoreCase("y"));
				} else if (c.getAllAccounts().size() == 1) {
					showAccount(c.getAllAccounts().get(0));
				} else
					System.out.println("You have no accounts");

			}
		} catch (Exception e) {
			System.err.println("Object must be Employee or Customer");
		}

	}
	

}
