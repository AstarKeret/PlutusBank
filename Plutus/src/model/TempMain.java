package model;
import main.ManagmentSystem;
import model.Customer.Gender;
import transaction.TransferMoney;

public class TempMain {

	private static Customer customer;
	private static Account account;
	private static Employee employee;
	
	public static void main(String[] args) {
		ManagmentSystem.getManager().getAllCustomer().add(new Customer("Ido", "Levi", "IdoLevi", "96856", Gender.Male, "01/01/1995", "058544555"));
		ManagmentSystem.getManager().getAllCustomer().get(0).getAllAccounts().add(new Account(100));
		customer = ManagmentSystem.getManager().getAllCustomer().get(0);
		account = ManagmentSystem.getManager().getAllCustomer().get(0).getAllAccounts().get(0);
		TransferMoney.transfer(args);
	}
	
	public static Customer getCustomer() {
		return customer;
	}
	
	public static Account getAccount() {
		return account;
	}
	
	public static Employee getEmployee() {
		return employee;
	}
}
