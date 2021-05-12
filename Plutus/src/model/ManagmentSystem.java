package model;

import java.util.ArrayList;

import transaction.BankingTransactionBoundary;

public class ManagmentSystem {
	private static ManagmentSystem manager = new ManagmentSystem();
	private ArrayList<Customer> allCustomer;
	private ArrayList<Employee> allEmployees;
	
	public ManagmentSystem() {
		allCustomer = new ArrayList<>();
		allEmployees = new ArrayList<>();
	}

	public static ManagmentSystem getManager() {
		return manager;
	}
	
	public ArrayList<Customer> getAllCustomer() {
		return allCustomer;
	}

	public void addAllCustomer(Customer customer) {
		allCustomer.add(customer);
	}

	public ArrayList<Employee> getAllEmployees() {
		return allEmployees;
	}

	public void addAllEmployees(Employee employees) {
		allEmployees.add(employees);
	}

}
