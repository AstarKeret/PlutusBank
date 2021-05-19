package main;
import java.util.ArrayList;

import model.Customer;
import model.Employee;

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
	
	public Customer findCustomer(String userName,String pass) {
		Customer customer=null;
		while(allEmployees.iterator().hasNext())
		{
			if(allEmployees.iterator().next().getUserName()==userName && allEmployees.iterator().next().getUserName()==pass)
			{
				customer=allCustomer.iterator().next();
			}
		}
		return customer;
	}
	public Employee findEmployee(String userName,String pass) {
		Employee employee=null;
		while(allEmployees.iterator().hasNext())
		{
			if(allEmployees.iterator().next().getUserName()==userName && allEmployees.iterator().next().getUserName()==pass)
			{
				employee=allEmployees.iterator().next();
			}
		}
		return employee;
		}

}
