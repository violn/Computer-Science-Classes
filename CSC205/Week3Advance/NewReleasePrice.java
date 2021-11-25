public class NewReleasePrice extends Price implements GetDiscountPayedInCash
{
	@Override
	public double getDiscountPayedInCash()
	{
		return .01;
	}

	@Override
	public int getPriceCode()
	{
		return Movie.NEW_RELEASE;
	}

	@Override
	double getCharge(int daysInRent)
	{
		return daysInRent * 3D;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented)
	{
		return daysRented > 1 ? 2 : 1;
	}
}