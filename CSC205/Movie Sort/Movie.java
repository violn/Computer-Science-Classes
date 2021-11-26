public class Movie
{
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	private Price price;

	public Movie(String title, int args)
	{
		super();
		this.title = title;
		switch (args)
		{
			case Movie.REGULAR:
				this.price = new RegularPrice();
				break;
			case Movie.CHILDREN:
				this.price = new ChildrensPrice();
				break;
			case Movie.NEW_RELEASE:
				this.price = new NewReleasePrice();
				break;
			default:
				break;
		}
	}

	public Price getPrice()
	{
		return this.price;
	}

	public String getTitle()
	{
		return this.title;
	}
}