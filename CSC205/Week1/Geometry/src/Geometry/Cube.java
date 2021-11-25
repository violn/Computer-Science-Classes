package Geometry;

public record Cube(double length) implements ThreeDimensionalShape
{
	public double getLength()
	{
		return length;
	}

	public double getSurfaceArea()
	{
		return 6 * Math.pow(length, 2);
	}

	public double getVolume()
	{
		return Math.pow(length, 3);
	}
	
	@Override
	public String toString()
	{
		return String.format("Cube [Height: %s Width: %s Depth: %s Surface Area: %s Volume: %s]", length, length, length, getSurfaceArea(), getVolume());
	}
}
