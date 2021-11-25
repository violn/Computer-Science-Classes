import java.util.StringTokenizer;

public class TokenizerLongString {
    public static void main(String[] args) {
        String sourceString = "Anmol_Deep_Java_Code_Geeks_Java_Author";
		System.out.println("Source String is " + sourceString +  " | Delimiter is _Java");
        //Creates a tokenizer with delimiter "_Java"
		StringTokenizer st = new StringTokenizer(sourceString, "_Java");
        //Gets and prints the token count
		System.out.println("testLongStringDelimiter : Count-Tokens " + st.countTokens());
        //Iterates throught the tokens
		while (st.hasMoreTokens()) {
			System.out.println("testLongStringDelimiter : Next-Token = " + st.nextToken());
		}
		System.out.println(" ------------------------------------------------------------------------------ ");
    }
}
