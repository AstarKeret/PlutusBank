package main;

import java.util.Scanner;  // Import the Scanner class

import model.Account;
import model.Customer;
import model.Employee;
import model.Customer.Gender;
import model.Employee.Type;


public class Main {
	public static ManagmentSystem manager = ManagmentSystem.getManager();
	public static Scanner data = new Scanner(System.in);	  // Create a Scanner object
	public static String[] arg;
	public static void main(String[] args)   {
		arg = args;
		manager.addAllEmployees(new Employee( "Bob", "aa", "a", "123",  Type.Manager));
		manager.addAllEmployees(new Employee( "Bob", "bb", "b", "12",  Type.Banker));
		manager.addAllEmployees(new Employee( "Bob", "cc", "c", "1",  Type.Banker));
		ManagmentSystem.getManager().getAllCustomer().add(new Customer("Or", "Choen", "OrChoen", "12345", Gender.Male, "01/01/1995", "058544555"));
		ManagmentSystem.getManager().getAllCustomer().get(0).addAllAccount(new Account(100));

		boolean Infinity = true;	
		

		do {	
			int select = 0;
			try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
			System.err.println("Welcome to Plutus\n");
			System.out.println("Select one of the displayed options and enter its number after the #\n");
			System.out.println("1. Customer Login\n");// 1
			System.out.println("2. I want to join!\n");// 2
			System.out.println("3. I'm Plutus worker\n");// 3
			
			try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}	
			System.err.print("#  ");
			try {
				select = data.nextInt();  // select
		
			}catch (Exception e) {
				e.printStackTrace();
				data.next();
			}
			if(select != 0 && select <= 3)
				Infinity=Login.start(select);
			}while (Infinity);
	}
	
}

