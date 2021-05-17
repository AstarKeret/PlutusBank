package aa;
import java.util.Scanner;  // Import the Scanner class

public class Main {

	public static void main(String[] args)   {
		boolean Infinity=true;	
		Scanner data = new Scanner(System.in);  // Create a Scanner object
			do {
						
		System.err.println("Welcome to Plutus\n");
		System.out.println("Select one of the displayed options and enter its number after the #\n");
		System.out.println("1. Customer Login\n");// 1
		System.out.println("2. I want to join!\n");// 2
		System.out.println("3. I'm Plutus worker\n");// 3
		System.err.print("#  ");
		
		int select = data.nextInt();  // select
        Infinity=Login.start(select);
		
			}while (Infinity==true);
		data.close();
	}
 
	
}

