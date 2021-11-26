public abstract class Price
{
	abstract int getPriceCode();
	abstract double getCharge(int daysInRent);
	abstract int getFrequentRenterPoints(int daysRented);
}