public class Utility
{
    public static String leftPadding(String input, char ch, int l)
    {
        return String.format("%" + l + "s", input).replace(' ', ch);
    }

    public static String rightPadding(String input, char ch, int l)
    {
        return String.format("%" + (-l) + "s", input).replace(' ', ch);
    }
}