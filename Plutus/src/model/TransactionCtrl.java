package model;

import java.util.ArrayList;
import java.util.Scanner;

import transaction.BankingTransactionBoundary;

public class TransactionCtrl {
	public static Scanner scanner = new Scanner(System.in);
	public final static String MY_ID = "afeka08";
	
	public void receivingMoney(BankingTransactionBoundary trans) {
		Account destination = searchAccount(trans.getDestination().getAccountNumber());
		if(destination != null){
			destination.setBalance(destination.getBalance() + trans.getAmount());	//update amount
			destination.addTransactions(new Transaction(trans.getSource(), trans.getComment(), trans.getDateStamp(), trans.getAmount()));	//add transaction
			//notify()
		}
		else {
			
		}
	}

	private Account searchAccount(String accountNumber) {
		ArrayList<Customer> allCustomer = ManagmentSystem.getManager().getAllCustomer();
		for(int i = 0; i < allCustomer.size() ; i ++) 
			for(int j = 0 ; j < allCustomer.get(i).getAllAccounts().size() ; j++) 
				if(allCustomer.get(i).getAllAccounts().get(j).getAccountNumber().equals(accountNumber))
					return allCustomer.get(i).getAllAccounts().get(j);
		return null;
	}
}
