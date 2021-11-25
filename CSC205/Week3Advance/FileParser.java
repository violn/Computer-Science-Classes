import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileParser
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
		
		for (var rentalItem : rentals)
		{
			ColorConsole.setForeGroundColor(ColorConsole.TEXT_WHITE);
			var statement = rentalItem.statement();
			Files.write(Paths.get("MovieReport.txt"), (statement + ColorConsole.fill('-', 60) + "\n").getBytes(), StandardOpenOption.APPEND);
		}
	}
}
