import java.util.StringTokenizer;

public class TokenizerDelimNextToken {
    public static void main(String[] args) {
		String sourceString = "This-String_Example-has space , hyphen-and_hyphen-and_underscores";
		StringTokenizer st = new StringTokenizer(sourceString);
		System.out.println("Source String is " + sourceString);
        //Prints the token before the next underscore which is This-String
		if (st.hasMoreTokens()) {
			// nextToken with delimiter _
			System.out.println("testNextTokenWithDelim | Delimiter _ : Next-Token = " + st.nextToken("_"));
		}
        //Iterates through the rest of the tokens starting with _Example
		while (st.hasMoreTokens()) {
			// nextToken with delimiter -
			System.out.println("testNextTokenWithDelim | Delimiter - : Next-Token = " + st.nextToken("-"));
		}
		System.out.println(" ------------------------------------------------------------------------------ ");
    }
}