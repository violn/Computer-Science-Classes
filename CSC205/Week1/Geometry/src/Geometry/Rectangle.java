package Geometry;

public class Rectangle implements TwoDimensionalShape
{
	private final double height;
	private final double width;
	
	Rectangle(double height, double width)
	{
		this.height = height;
		this.width = width;
	}

	public double getHeight()
	{
		return height;
	}

	public double getWidth()
	{
		return width;
	}

	public double getArea()
	{
		return height * width;
	}

	public double getPerimeter()
	{
		return 2 * (height + width);
	}

	@Override
	public String toString()
	{
		return String.format("Rectangle [Height: %s Width: %s Area: %s Perimeter: %s]", height, width, getArea(), getPerimeter());
	}
}
