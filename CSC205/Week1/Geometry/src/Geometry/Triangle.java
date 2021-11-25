package Geometry;

public record Triangle(double side1, double side2,  double side3) implements TwoDimensionalShape
{
	public void getSides() 
	{
		System.out.println(String.format("Triangle [Side 1: %s%nSide 2: %s%nSide 3: %s%n]", side1, side2, side3));
	}

	public double getArea()
	{
		double s = getPerimeter() / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}

	public double getPerimeter()
	{
		return side1 + side2 + side3;
	}

	@Override
	public String toString()
	{
		return String.format("Triangle [Side 1: %sSide 2: %s%nSide 3: %sArea: %sPerimeter: %s]", side1, side2, side3, getArea(), getPerimeter());
	}
}
