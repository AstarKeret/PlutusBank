
package main;
import java.util.Scanner;

import menus.CustomerMenu;
import menus.EmployeeMenu;
import model.Account;
import model.Customer;
import model.Customer.Gender;
import model.Employee.Type;
import model.Employee;
import usecases.CreateNewCustomer;


public class Login {

	static String userName; 
	static String password;
	static Scanner data = Main.data;  // Create a Scanner object
	static 	int exit=0;
	static Customer customerLogin= null;
	static Employee EmployeeLogin= null;
	public static Boolean start(int select, String[] args)//  Infinity=true => back to main menu
	{	
		
		try {
			switch(select)
			{
			case(1): // Customer login
			{
				do
					{
					System.out.println("Enter username");
					try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
					System.err.print("#  ");
					userName = data.next();  // Read user input
					try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
					System.out.println("Enter password");
					try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
					System.err.print("# ");
					password = data.next();  // Read password input
					System.out.println("Working");
					printP ();
					
					customerLogin=ManagmentSystem.getManager().findCustomer(userName,password);
					System.out.println(customerLogin.getFirstName());
					}while (customerLogin== null );  // try 3 times or 
				
				if(customerLogin!= null)
					CustomerMenu.run(customerLogin, args);
				else
					System.err.println("Cant Login back to main menu");
				return true;
			}
			case(2): //open Customer
			{
				CreateNewCustomer createNewCustomer = null;
				
				ManagmentSystem.getManager().addAllEmployees(   new Employee( "firstName",  "surName",  "userName",  "password", Type.Manager));
				 createNewCustomer = new CreateNewCustomer("Ido", "Levi", "IdoLevi", "1", Gender.Male, "01/01/1995", "058544555");
				if( createNewCustomer.registerCustomer())
				System.out.println("OK"); //fix
				return true;
			}
			case(3):
			{			
						do
					{
				System.out.println("Enter username");
				userName = data.nextLine();  // Read user input
				System.out.println("Enter password");
				password = data.nextLine();  // Read password input
				System.out.println("Working");
				printP ();
				exit++;
				EmployeeLogin=ManagmentSystem.getManager().findEmployee(userName,password);
				}while (EmployeeLogin== null && exit<=3);	
				if (EmployeeLogin!= null)
					EmployeeMenu.run(EmployeeLogin);
				System.err.println("Cant Login back to main menu");
				return true;
		}
			}
		} catch (Exception e) {
			return true;
		} 
		return true;

	}

	public static void printP ()
	{
		for(int i=0;i<=10;i++)
		{
			System.out.print(".");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();

	}

public static Customer getCustomerLogin() {
	return customerLogin;
}

public static Employee getEmployeeLogin() {
	return EmployeeLogin;
}

}
