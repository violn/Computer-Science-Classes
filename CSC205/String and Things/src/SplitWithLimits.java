public class SplitWithLimits {
    public static void main(String[] args) throws Exception {
		String source = "705-103-102-456-123 : 112 _343-1 789----";
		System.out.println(" Source String is " + source + " | Regex is - ");
		//Split with regex - and return 3 entries in array
		for (String x : source.split("-", 4)) {
			System.out.println("splitWithLimit (limit = 4) : Split Item -> " + x);
		}
		System.out.println(" ---------------------------------------------------------------- ");
		//Split with - and return all splits including trailing empty strings
		for (String x : source.split("-", -3)) {
			System.out.println("splitWithLimit (limit = -3): Split Item -> " + x);
		}
		System.out.println(" ---------------------------------------------------------------- ");
		//Split with - and return all splits discard the trailing empty strings
		for (String x : source.split("-", 0)) {
			System.out.println("splitWithLimit (limit = -3): Split Item -> " + x);
		}
		System.out.println(" ---------------------------------------------------------------- ");
    }
}
