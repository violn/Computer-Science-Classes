public class RegularPrice extends Price implements GetDiscountPayedInCash
{
	@Override
	public double getDiscountPayedInCash()
	{
		return .05;
	}

	@Override
	public int getPriceCode()
	{
		return Movie.REGULAR;
	}

	@Override
	double getCharge(int daysInRent)
	{
		double result = 2;
		if (daysInRent > 2)
		{
			result += (daysInRent - 2) * 1.5;
		}
		return result;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented)
	{
		return 1;
	}
}
