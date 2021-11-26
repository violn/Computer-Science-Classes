import java.util.Comparator;

public class PriceComparator implements Comparator<Movie> 
{
    public int compare(Movie m1, Movie m2) 
    {
        if (m1.getPrice().getPriceCode() > m2.getPrice().getPriceCode()) 
        {
            return 1;
        }

        else if (m1.getPrice().getPriceCode() < m2.getPrice().getPriceCode()) 
        {
            return -1;
        }

        return 0;
    }
}
