package usecases;

import java.util.Scanner;

public class Login {

	static String userName; 
	static String password;
	static Scanner data = new Scanner(System.in);  // Create a Scanner object
	static 	int exit=0;

	public static Boolean start(int select)//  Infinity=true => back to main menu
	{
		try {
			switch(select)
			{
	
			case(1): // Customer login
			{
				//	Customer customer;
				//	do
				//		{
				System.out.println("Enter username");
				System.err.print("#  ");
				userName = data.nextLine();  // Read user input
				System.err.println("");
				System.out.println("Enter password");
				System.err.print("# ");
				password = data.nextLine();  // Read password input
				System.out.println("Working");
				printP ();
				exit++;	
				//	customer=Customer.find(customer);
				//	}while (customer!= null  && exit<=3);  // try 3 times or 
				//if(customer!= null)
		//		CustomerMenu.run(Customer customer);
				//else
					System.err.println("Cant Login back to main menu");
				return true;
			}
			case(2): //open Customer
			{
				//     openCustomer
				return true;
	
			}
			case(3):
			{
				//	Worker worker;
				//		do
				//	{
				System.out.println("Enter username");
				userName = data.nextLine();  // Read user input
				System.out.println("Enter password");
				password = data.nextLine();  // Read password input
				System.out.println("Working");
				printP ();
				exit++;
				//		worker=Worker.find(customer);
				//}while (worker!= null && exit<=3);	
				//if (worker!= null)
				//workerMenu.run(worker);
				System.err.println("Cant Login back to main menu");
				return true;
	
			}
		}
		}catch (Exception e) {
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
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();

	}
}
