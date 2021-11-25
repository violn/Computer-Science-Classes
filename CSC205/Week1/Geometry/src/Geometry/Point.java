package Geometry;

public record Point(double x, double y)
{
	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public double distanceFrom(Point point)
	{
		return Math.sqrt(Math.pow(point.getX() - x, 2) + Math.pow(point.getY() - y, 2));
	}
	
	public String getCoordinates()
	{
		return "(" + x + ", " + y + ")";
	}

	@Override
	public String toString()
	{
		return String.format("Point [Coordinate: (%s,%s) Distance from Origin: %s]", x, y, distanceFrom(new Point(0, 0)));
	}
}