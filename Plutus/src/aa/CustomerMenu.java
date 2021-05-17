package aa;

import java.util.Scanner;

public class CustomerMenu {
//	static void run(Customer customer)// After Login
	{
		boolean flag=false;	
		Scanner data = new Scanner(System.in);  // Create a Scanner object

		do {
		System.err.println("Welcome to Plutus Customer Menu\n");
		System.out.println("Select one of the displayed options and enter its number after the #\n");
		System.out.println("1. Show my data \n");// 1
		System.out.println("2. Show my accounts \n");// 2
		System.out.println("3. Open new account\n");// 3
		System.out.println("4. Logout\n");// 3
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
			flag=true;
			break;
		}
		
		
		
		
		}while(flag==false);
		
	}
}
