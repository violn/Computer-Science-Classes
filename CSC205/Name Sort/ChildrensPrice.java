public class ChildrensPrice extends Price implements GetDiscountPayedInCash
{
	@Override
	public double getDiscountPayedInCash()
	{
		return .02;
	}

	@Override
	public int getPriceCode()
	{
		return Movie.CHILDREN;
	}

	@Override
	double getCharge(int daysInRent)
	{
		double result = 1.5;
		if (daysInRent > 3)
		{
			result += (daysInRent - 3) * 1.5;
		}
		return result;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented)
	{
		return 1;
	}

}
