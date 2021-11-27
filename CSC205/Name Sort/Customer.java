import java.util.ArrayList;
import java.util.List;

public class Customer implements Comparable<Customer>
{
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name)
	{
		super();
		this.name = name;
	}

	public void addRentals(Rental rental)
	{
		rentals.add(rental);
	}


	public Rental getRental(int index)
	{
		return rentals.get(index);
	}
	
	public String getName()
	{
		return this.name;
	}

	public String statement()
	{
		var totalAmount = 0.00;
		var frequentRenterPoints = 0;
		String result = "Rental Records for " + this.getName() + "\r\n";
		for (Rental rental : rentals)
		{
			var daysInRental = rental.getDaysRented();
			var moviePrice = rental.getMovie().getPrice();

			totalAmount = moviePrice.getCharge(daysInRental);
			// show detail rentals figures
			result = result + "\t" + rental.getMovie().getTitle() + "\r\n";
			frequentRenterPoints = moviePrice.getFrequentRenterPoints(daysInRental);
		}
		// add footer
		result = result + "\t" + "Amount owed is : " + totalAmount + "\r\n";
		result = result + "\t" + "You earned : " + frequentRenterPoints + " frequent renter points" + "\r\n";
		return result;
	}

	@Override
	public int compareTo(Customer o)
	{
		return this.getName().compareTo(o.getName());
	}
}
