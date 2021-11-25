public class SplitPolynomial {
    public static void main(String[] args) {
		String expr = "10*a^2 + 1/3*b - c^2";
		System.out.println(" Source String is " + expr);
		//Splits the expression with delimiters + * / ^ space -
		String regex = "[+*/^ \\-]+";
		System.out.println(" Splitting with Regex - " + regex);
        //Prints the created array of tokens
		for (String str : expr.split(regex)) {
			System.out.println("splitPolynomial - " + str);
		}
    }
}
