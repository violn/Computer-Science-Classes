import java.util.StringTokenizer;

public class TokenizerColon {
    public static void main(String[] args) {
		String sourceString = "Computer Science:Programming:Java:String Tokenizer:Example";
        //Creates a tokenizer that doesn't include the delimter of colon
		StringTokenizer st = new StringTokenizer(sourceString, ":");
		System.out.println("Source String is " + sourceString + "| Delimiter is : ");
		System.out.println("testCountTokens : " + st.countTokens());
		while (st.hasMoreTokens()) {
			System.out.println("testDelimiterColon : Next-Token = " + st.nextToken());
		}
		System.out.println(" ------------------------------------------------------------------------------ ");
        //Creates a tokenizer that includes the delimter of colon
		st = new StringTokenizer(sourceString, ":", true);
		System.out.println("testReturnDelimiters : Count-Tokens " + st.countTokens());
		while (st.hasMoreTokens()) {
			System.out.println("testReturnDelimiters : Next-Token = " + st.nextToken());
		}
		System.out.println(" ------------------------------------------------------------------------------ ");
    }
}