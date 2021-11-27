import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NameSort
{
	public static void main(String[] args) throws Exception
	{
		List<String> lines = Files.readAllLines(Paths.get("Rentals.txt"));
		List<Customer> rentals = new ArrayList<>();

		for(String r : lines)
		{
			String[] rentalInfo = r.split(",");
			var customer = new Customer(rentalInfo[0]);
			var movie = new Movie(rentalInfo[1], Integer.parseInt(rentalInfo[2]));
			var rental = new Rental(movie, Integer.parseInt(rentalInfo[3]));
			customer.addRentals(rental);
			rentals.add(customer);
		}

		Collections.sort(rentals);

		for (var rentalItem : rentals)
		{
			ColorConsole.setForeGroundColor(ColorConsole.TEXT_WHITE);
			var statement = rentalItem.statement();
			File file = new File("MovieReport.txt");
			if(file.createNewFile())
			{
				Files.write(Paths.get("MovieReport.txt"), (statement + ColorConsole.fill('-', 60) + "\n").getBytes(), StandardOpenOption.APPEND);
			}
			else
			{
				Files.write(Paths.get("MovieReport.txt"), ("").getBytes(), StandardOpenOption.WRITE);
				Files.write(Paths.get("MovieReport.txt"), (statement + ColorConsole.fill('-', 60) + "\n").getBytes(), StandardOpenOption.APPEND);
			}
		}

		System.out.println("File successfully made.");
	}
}