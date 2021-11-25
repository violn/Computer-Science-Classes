package  GeneralConcepts;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Step 1 Read this first
class ConsoleIO {
	public static void main(String[] args) throws IOException{

		writeToConsole(); // comment and uncomment as needed
		
		classicReadingFromKeyboard(); // comment and uncomment as needed

		readFromTheConsole(); // comment and uncomment as needed

		readLargeAmountOfData(); //// comment and uncomment as needed
	}

	public static void writeToConsole() { // output

		var banner = "Welcome to CSC 110 2021";
		System.out.println(banner); // native console output
		// the above line of code is outputting the data to console
		// this is the default action as the default output is set to the console
		// if the default is set to printer it will print the characters to the printer.
		
	}

	public static void classicReadingFromKeyboard() {


		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your nationality: ");
		String nationality = scanner.nextLine();
		System.out.print("Your nationality is "+ nationality);

		System.out.print("Enter your age: ");
		int age = scanner.nextInt();

		System.out.print("Your age is : "+age);

		scanner.close();
	}

	public static void readFromTheConsole() { // output

		// if you want to read what you types in the console
		//Ref: https://www.codejava.net/java-se/file-io/3-ways-for-reading-input-from-the-user-in-the-console
		
		Console console = System.console();
		if (console == null) {
			System.out.println("No console: non-interactive mode!");
			System.exit(0);
		}
		
		System.out.print("Enter your username: ");
		String username = console.readLine();
		System.out.println("You Typed "+username);
		
		System.out.print("Enter your password: ");
		char[] password = console.readPassword();

		System.out.println("You Typed password "+password.toString());
		
		String passport = console.readLine("Enter your %d (th) passport number: ", 2);
		System.out.println("You Typed passport number "+passport);
		
	}

	public static void readLargeAmountOfData() throws IOException{
		// when you need to read large amount of data or read from an external data stream
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter your name: ");
		
		String name = reader.readLine();
		System.out.println("Your name is: " + name);
	}

}