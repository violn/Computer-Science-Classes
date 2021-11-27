public class Math {
	double result;
	public Math() {
		super();
	}
	

	public float sum(Integer initialValue, Integer... nums)
	{
		result = initialValue;
		for (int item : nums) {
			result += item;
		}
		
		return (float)result;
	}

	public double sum(Double def, Double... nums)
	{
		result = def;
		for (Double d : nums) {
			result += d;
		}

		return def;
	}
	// Driver code
}
