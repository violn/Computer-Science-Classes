public class Math {
	double result;
	public Math() {
		super();
	}

	// Overloaded sum(). This sum takes two int parameters
	public double sum(double x, double y)
	{   result = (x + y);
		return result;
	}
	
	// Overloaded sum(). This sum takes three int parameters
	public double sum(double x, double y, double z)
	{
		result =  (x + y + z);
		return result;
	}

	public int sum(int x, int y)
	{   result = (x + y);
		return (int)result;
	}
	
	// Overloaded sum(). This sum takes three int parameters
	public float sum(float x, float y, float z)
	{
		result = (x + y + z);
		return (float)result;
	}

	public double sum(double x)
	{   result = (result + x);
		return result;
	}

	public float sum(Integer... nums)
	{
		for (int item : nums) {
			result += item;
		}
		
		return (float)result;
	}
	// Driver code

	public double sum(Double... nums)
	{
		for (double num: nums)
		{
			result += num;
		}

		return result;
	}
}
