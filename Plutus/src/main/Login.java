
package main;
import java.util.Scanner;

import menus.CustomerMenu;
import menus.EmployeeMenu;
import model.Customer;
import model.Employee;
import model.Customer.Gender;
import usecases.CreateNewCustomer;

public class Login {

	static String userName; 
	static String password;
	static Scanner data = new Scanner(System.in);  // Create a Scanner object


	static 	int exit=0;
	static Customer customerLogin= null;
	static Employee EmployeeLogin= null;
	public static Boolean start(int select)//  Infinity=true => back to main menu
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
				userName = data.nextLine();  // Read user input
				try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
				System.out.println("Enter password");
				try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
				System.err.print("# ");
				password = data.nextLine();  // Read password input
				System.out.println("Working");
				printP ();
				exit++;	
				customerLogin=ManagmentSystem.getManager().findCustomer(userName,password);
					}while (customerLogin!= null  && exit<=3);  // try 3 times or 
				if(customerLogin!= null)
	     	CustomerMenu.run( customerLogin);
				else
					System.err.println("Cant Login back to main menu");
				return true;
			}
			case(2): //open Customer
			{
//				if(CreateNewCustomer.registerCustomer())
//				CreateNewCustomer.CreateNewCustomer("Ido", "Levi", "IdoLevi", "96856", Gender.Male, "01/01/1995", "058544555");
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
				}while (EmployeeLogin!= null && exit<=3);	
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
