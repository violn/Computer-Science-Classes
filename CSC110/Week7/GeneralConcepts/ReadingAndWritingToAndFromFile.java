package GeneralConcepts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

//Step 2: Read this after ConsoleIO.Java

public class ReadingAndWritingToAndFromFile {
	public static void main(String[] args) throws IOException{
		// there are many ways to read and write from the files
		// the example here is the most convenient ways and a current ways to read and write from file
		//ref:https://www.codejava.net/java-se/file-io/3-ways-for-reading-input-from-the-user-in-the-console

		//demo
		// now lst us read the product listed in a file from products.txt
		// the file name is case sensitive for many OS platforms
		// // Microsoft Windows syntax
		// Path path = Paths.get("C:\\home\\joe\\foo");

		// // Unix, Mac and Solaris syntax
		// Path path = Paths.get("/home/joe/foo");

		var productFile = "GeneralConcepts/Products.txt"; // if the file is in the same folder as the Java Executable
		//readFromFile(productFile);
		//readFromFileAndParseProducts(productFile);
		readProducts(productFile);
	}

	// Step Part 1: 
	public static void readFromFile(String fileName) throws IOException{ // throws exception is required here 
		//as there are many edge cases that the file may not be found, it may not have ability to read due to permissions etc.

		// Converts the input Path
        // to an absolute path.
        // Generally, this means pre-pending
        // the current working
        // directory.  If this example
        // were called like this:
        //     java FileTest foo
        // the getRoot and getParent methods
        // would return null
        // on the original "inputPath"
        // instance.  Invoking getRoot and
        // getParent on the "fullPath"
        // instance returns expected values.
    
		var filePath = Paths.get(fileName);
		System.out.println("The File Path is :" +filePath);
		var absoluteOath = filePath.toAbsolutePath(); // you need to pass the absolute path to the Files.readAllLines method
		var linesRead = Files.readAllLines(absoluteOath);

		// linesRead returns a list or collections of strings
		// as any thing you read from a file is always a string data type, it does not know it is int or long etc
		// you will need to convert it as you need

		// output what was read from the file
		for (String line : linesRead) { // is from every line in the list of lines in the linesRead variable
			System.out.println(line);
		}
	}
	
    // Step part 2: 
	public static void readFromFileAndParseProducts(String fileName) throws IOException{ // throws exception is required here 
		// much of the code is the same as readFromFile
		var filePath = Paths.get(fileName);
		System.out.println("The File Path is :" +filePath);
		var absoluteOath = filePath.toAbsolutePath(); // you need to pass the absolute path to the Files.readAllLines method
		var linesRead = Files.readAllLines(absoluteOath);

		// linesRead returns a list or collections of strings
		// as any thing you read from a file is always a string data type, it does not know it is int or long etc
		// you will need to convert it as you need

		// output what was read from the file
		for (String line : linesRead) { // is from every line in the list of lines in the linesRead variable
			var dataLine = line.split(","); // now every line elements in the products.txt is separated by ","
			//so the variable dataLine will contain two parts ; Product Name and weight
			System.out.println("Product Name:"+ dataLine[0]); // the 0 here means the index of the split items. The first index in the list is 0 and not 1

			System.out.println("ProductWeight :"+dataLine[2]);

		}
	}

	// Step part 2: 
	public static void readProducts(String fileName) throws IOException{ // throws exception is required here 
		// much of the code is the same as readFromFileAndParseProducts
		var filePath = Paths.get(fileName);
		System.out.println("The File Path is :" +filePath);
		var absoluteOath = filePath.toAbsolutePath(); // you need to pass the absolute path to the Files.readAllLines method
		var linesRead = Files.readAllLines(absoluteOath);


		// now let us create a variable to store the list of products which you have done in your previous assignment
		 var products = new ArrayList<Product>(); 

		// output what was read from the file
		for (String line : linesRead) { // is from every line in the list of lines in the linesRead variable
			var dataLine = line.split(","); // now every line elements in the products.txt is separated by ","
			//so the variable dataLine will contain two parts ; Product Name and weight

			var product = new Product(dataLine[0], Integer.parseInt(dataLine[1].trim())); // the trim() function is helpful to trim away empty and hidden characters
			products.add(product);
		}


		//now print the products
		// output what was read from the file
		for (Product product : products) { 
			System.out.println(product.toString());
		}
	}
}
