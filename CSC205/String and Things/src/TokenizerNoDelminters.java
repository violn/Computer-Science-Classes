import java.util.StringTokenizer;

public class TokenizerNoDelminters {
    public static void main(String[] args) {
		String sourceString = "This is a\nsample of\nnew big line-with\ttabs and\rcarriage-returns";
		System.out.println("Source String is " + sourceString);
		//Create a StringTokenizer with default delimiters
		StringTokenizer st = new StringTokenizer(sourceString);
        //Iterate through the tokens
		while (st.hasMoreTokens()) {
			System.out.println("testNoDelimiters : Next-Token = " + st.nextToken());
		}
		System.out.println(" ------------------------------------------------------------------------------ ");
        //Create a StringTokenizer with space as a delimter
		st = new StringTokenizer(sourceString, " ");
		while (st.hasMoreTokens()) {
			System.out.println("testSpaceDelimiter : Next-Token = " + st.nextToken());
		}
		System.out.println(" ------------------------------------------------------------------------------ ");
    }
}