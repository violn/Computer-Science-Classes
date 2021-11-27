public class Movie
{
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private Price _price;

	public Movie(String title, int args)
	{
		super();
		this._title = title;
		switch (args)
		{
			case Movie.REGULAR:
				this._price = new RegularPrice();
				break;
			case Movie.CHILDREN:
				this._price = new ChildrensPrice();
				break;
			case Movie.NEW_RELEASE:
				this._price = new NewReleasePrice();
				break;
			default:
				break;
		}
	}
	
	public Price getPrice()
	{
		return this._price;
	}

	public String getTitle()
	{
		return this._title;
	}

}