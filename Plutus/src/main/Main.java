package main;

import java.util.Scanner;  // Import the Scanner class

import model.Employee;
import model.Employee.Type;


public class Main {
	static ManagmentSystem manager = ManagmentSystem.getManager();
	public static void main(String[] args)   {
		manager.addAllEmployees(new Employee( "Bob", "aa", "a", "123",  Type.Manager));
		manager.addAllEmployees(new Employee( "Bob", "bb", "b", "12",  Type.Banker));
		manager.addAllEmployees(new Employee( "Bob", "cc", "c", "1",  Type.Banker));
		boolean Infinity=true;	
		
		Scanner data = new Scanner(System.in);  // Create a Scanner object
			do {	
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		System.err.println("Welcome to Plutus\n");
		System.out.println("Select one of the displayed options and enter its number after the #\n");
		System.out.println("1. Customer Login\n");// 1
		System.out.println("2. I want to join!\n");// 2
		System.out.println("3. I'm Plutus worker\n");// 3
		
		try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}	
		System.err.print("#  ");
		
		int select = data.nextInt();  // select
        Infinity=Login.start(select, args);
		
			}while (Infinity==true);
		data.close();
	}
}

