import java.util.ArrayList;
import java.util.List;

public class Customer
{
	private String _name;
	private List<Rental> _rentals = new ArrayList<>();

	public Customer(String name)
	{
		super();
		this._name = name;
	}

	public void addRentals(Rental rental)
	{
		_rentals.add(rental);
	}

	public String getName()
	{
		return this._name;
	}

	public String statement()
	{
		var totalAmount = 0.00;
		var frequentRenterPoints = 0;
		String result = "Rental Records for " + this.getName() + "\r\n";
		for (Rental rental : _rentals)
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
}
