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
		System.out.println("1. Show my data \n");// 1
		System.out.println("2. Show my accounts \n");// 2
		System.out.println("3. Open new account\n");// 3
		System.out.println("4. Select an account\\n");// 4
		System.out.println("5. Logout\n");// 3
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		System.err.print("#  ");
			
		int select = data.nextInt();  // select
		
		switch(select)
		{
		case (1):
			//show customer
			break;
		case (2):
			// show accounts
			break;
		case (3):
			// open accounts
			break;
		case (4):
			switch(employeeLogin.getType())
			{
			case Manager:
				break;
			case Banker:
				break;
			   }
		break;
		case (5):
			flag=true;
			break;
		}
		}while(flag==false);
		data.close();
	}
	}


