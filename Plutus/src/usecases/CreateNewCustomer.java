package usecases;

import java.util.ArrayList;
import model.Customer;
import model.Employee;
import model.ManagmentSystem;

public class CreateNewCustomer extends Customer {
	public CreateNewCustomer(String firstName, String surName, String userName, String password, Gender type,
			String DOB, String phoneNumber) {
		super(firstName, surName, userName, password, type, DOB, phoneNumber);

	}

	private boolean searchManager() {

		ArrayList<Employee> employees = ManagmentSystem.getManager().getAllEmployees();

		for (Employee employee : employees) {
			if (employee.getType() == Employee.Type.Manager)
				;
			return true;
		}

		return false;

	}

	public boolean registerCustomer() {
		if (searchManager()) {
			ManagmentSystem.getManager().addAllCustomer(this);

		}

		return false;

	}

}
