package Geometry;

public record Line(double m, double b)
{
	public double getSlope()
	{
		return m;
	}

	public double getYIntercept()
	{
		return b;
	}

	public double getXIntercept()
	{
		return -b / m;
	}

	public double getY(double x)
	{
		return m * x + b;
	}

	public double getX(double y)
	{
		return (y - b) / m;
	}

	public boolean hitsPoint(Point p)
	{
		return p.getX() == getX(p.getY());
	}

	public String getEquation()
	{
		return "y = " + m + "x + " + b;
	}

	@Override
	public String toString()
	{
		return String.format("Line [Equation: y = %sx + %s Y-Intercept: %s X-Intercept: %s]", m, b, getYIntercept(), getXIntercept());
	}
}
