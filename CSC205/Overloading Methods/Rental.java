public class Rental
{
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented)
	{
		super();
		this._movie = movie;
		this._daysRented = daysRented;
	}

	public Rental(Movie movie)
	{
		super();
		this._movie = movie;
		this._daysRented = 1;
	}

	public Movie getMovie()
	{
		return this._movie;
	}

	public void setMovie(Movie movie)
	{
		this._movie = movie;
	}

	public int getDaysRented()
	{
		return this._daysRented;
	}

	public void setDaysRented(int daysRented)
	{
		this._daysRented = daysRented;
	}
}
