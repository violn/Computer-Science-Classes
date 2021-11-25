public class Utility
{

    // Function to perform left padding
    public static String leftPadding(String input, char ch, int l)
    {

        return String
                // First left pad the string
                // with space up to length L
                .format("%" + l + "s", input)
                // Then replace all the spaces
                // with the given character ch
                .replace(' ', ch);
    }

    // Function to perform right padding
    public static String rightPadding(String input, char ch, int l)
    {

        return String
                // First right pad the string
                // with space up to length L
                .format("%" + (-l) + "s", input)
                // Then replace all the spaces
                // with the given character ch
                .replace(' ', ch);
    }

    // Driver code
    public static void main(String[] args)
    {
        Customer c1 = new Customer("David Smith");
        Customer c2 = new Customer("Mary Ann");
        Customer c3 = new Customer("Jack Moore");

        c1.addRentals(new Rental(new Movie("No Time to Die", Movie.NEW_RELEASE), 3));
        c2.addRentals(new Rental(new Movie("Anna", Movie.CHILDREN), 2));
        c3.addRentals(new Rental(new Movie("Anna", Movie.REGULAR), 1));

        ColorConsole.printBanner("VIDEO RENTAL");
        System.out.println(c1.statement());
        System.out.println(c2.statement());
        System.out.println(c3.statement());
    }
}