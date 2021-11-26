import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieSort
{
	public static void main(String[] args) throws Exception
	{
		ColorConsole.clearConsole();
		ArrayList<Movie> moviesList = new ArrayList<>();
		List<String> lines = Files.readAllLines(Paths.get("Rentals.txt"));
		List<Customer> rentals = new ArrayList<>();

		for(String r : lines)
		{
			String[] rentalInfo = r.split(",");
			var customer = new Customer(rentalInfo[0]);
			var movie = new Movie(rentalInfo[1], Integer.parseInt(rentalInfo[2]));
			moviesList.add(movie);
			var rental = new Rental(movie, Integer.parseInt(rentalInfo[3]));
			customer.addRentals(rental);
			rentals.add(customer);

			if(rentals.size() == 10)
			{
				break;
			}
		}

		ColorConsole.setForeGroundColor(ColorConsole.TEXT_YELLOW);
		ColorConsole.println("\nOriginal reports: ");
		rentals.forEach(r -> System.out.println(r.statement() + ColorConsole.fill('-', 60)));

		rentals = sortRentals(rentals, moviesList, new TitleComparator());
		ColorConsole.setForeGroundColor(ColorConsole.TEXT_BLUE);
		ColorConsole.println("\nReports sorted by title: ");
		rentals.forEach(r -> System.out.println(r.statement() + ColorConsole.fill('-', 60)));

		rentals = sortRentals(rentals, moviesList, new PriceComparator());
		ColorConsole.setForeGroundColor(ColorConsole.TEXT_CYAN);
		ColorConsole.println("\nReports sorted by movie price code: ");
		rentals.forEach(r -> System.out.println(r.statement() + ColorConsole.fill('-', 60)));
	}

	public static List<Customer> sortRentals(List<Customer> rentals, List<Movie> movies,Comparator<Movie> comparator)
	{
		List<Customer> sorted_rentals = new ArrayList<>();

        Collections.sort(movies, comparator);
		for (int i = 0; i < rentals.size(); i++) 
		{
			for (Customer customer : rentals) {
				if(customer.getRental(0).getMovie().equals(movies.get(i)))
				{
					sorted_rentals.add(customer);
					break;
				}
			}
		}

		return sorted_rentals;
	}
}