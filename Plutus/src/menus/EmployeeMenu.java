package menus;

import java.util.Scanner;

import model.Employee;

public class EmployeeMenu {

	public static void run(Employee employeeLogin) {
		boolean flag=false;	
		Scanner data = new Scanner(System.in);  // Create a Scanner object

		do {
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		
		System.err.println("Welcome to Plutus Employee Menu\n");
		System.out.println("Select one of the displayed options and enter its number after the #\n");
		System.out.println("1. Select a castumer\n");// 1
		System.out.println("2. Select an account\n");// 2
		System.out.println("3. Manager connection\n");// 3
		System.out.println("4. Logout\n");// 4
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		System.err.print("#  ");
			
		int select = data.nextInt();  // select
		
		switch(select)
		{
		case (1):
			//Select a costumer data
			break;
		case (2):
			// 	select an account data 

			break;
		case (3):
			switch(employeeLogin.getType())
			{
			case Manager:
				System.out.println("Welcome"+employeeLogin.getFirstName()+employeeLogin.getSurName());
				System.out.println("You are logged in to a user authentication system");
				System.out.println("There are no users waiting for approval");
				break;
			case Banker:
				System.out.println("Access denied");
				break;
			   }
		break;
		case (4):
			flag=true;
			break;
		}
		}while(flag==false);
		data.close();
	}
	}




