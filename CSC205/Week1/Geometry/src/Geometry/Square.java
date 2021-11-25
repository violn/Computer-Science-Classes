package Geometry;

public class Square extends Rectangle 
{
	public Square(double side) 
	{
		super(side, side);
	}

	@Override
	public String toString()
	{
		return String.format("Square [Length: %s Area: %s Perimeter: %s]", getHeight(), getArea(), getPerimeter());
	}
}
