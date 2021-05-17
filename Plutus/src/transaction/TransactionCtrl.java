package transaction;

import java.util.ArrayList;
import java.util.Scanner;

import model.Account;
import model.Customer;
import model.Main;
import model.ManagmentSystem;
import model.TempMain;
import model.Transaction;

public class TransactionCtrl {
	//public static Scanner scanner = new Scanner(System.in);
	public final static String MY_ID = "afeka08";
	private String[] args;
	private Account account;
	
	public TransactionCtrl() {
		
	}
	
	public TransactionCtrl(String[] args) {
		this.args = args;
	}
	
	public void receivingMoney(BankingTransactionBoundary trans) {
		Account destination = searchAccount(trans.getDestination().getAccountNumber());
		if(destination != null){
			destination.setBalance(destination.getBalance() + trans.getAmount());	//update amount
			destination.addTransactions(new Transaction(trans.getSource(), trans.getComment(), trans.getDateStamp(), trans.getAmount()));	//add transaction
			//notify
		}
		else 
			sendMoney(new BankingTransactionBoundary(trans.getDestination(), trans.getSource(), "The requested account was not found", trans.getAmount()));	//notify
		
	}

	private Account searchAccount(String accountNumber) {
		ArrayList<Customer> allCustomer = ManagmentSystem.getManager().getAllCustomer();
		for(int i = 0; i < allCustomer.size() ; i ++) 
			for(int j = 0 ; j < allCustomer.get(i).getAllAccounts().size() ; j++) 
				if(allCustomer.get(i).getAllAccounts().get(j).getAccountNumber().equals(accountNumber))
					return allCustomer.get(i).getAllAccounts().get(j);
		return null;
	}
	
	public void sendMoney(AccountBoundary destination, double amount, String commant) {
		Customer tmp = TempMain.getCustomer();
		account = TempMain.getAccount();
		if(account.getBalance() < amount) {	//check balance
			System.out.println("Sorry, you do not have enough money in your account to transfer this amount/nWould you like to continue the transfer and choose a different amount? <y/n>");
			return;
			//			while(true) {
//				
//			}
		}
		AccountBoundary source = new AccountBoundary(account.getAccountNumber(), MY_ID, " ", tmp.getFirstName() + " " + tmp.getSurName());
		sendMoney(new BankingTransactionBoundary(source, destination, commant, amount));

	}
	
	public Boolean sendMoney(BankingTransactionBoundary trans) {
		try (TransactionSession ts = new TransactionSession(MY_ID, args)){

			ts.sendMoney(trans);
			account.setBalance(account.getBalance() - trans.getAmount());	//update account
			System.err.println("type any key to quit");
		}catch (Exception e) {
			System.err.println("error");
		}
		return false;
	}
}
