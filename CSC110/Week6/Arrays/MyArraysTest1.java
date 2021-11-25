package Arrays;
import java.util.Arrays;


// start here
public class MyArraysTest1
{
    public static void main(String[] args)
    {
        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        // Create
        Product[] products = { door, floorPanel ,window};

        // Print
        System.out.println(Arrays.toString(products));
        
        //Arrays are fixed and cannot add a new elements to it
        //Arrays  do not have "add method"

        // See MyArraysTest2.java for a utility method add
        // this is not an efficient and elegant solution.
       
    }

}
