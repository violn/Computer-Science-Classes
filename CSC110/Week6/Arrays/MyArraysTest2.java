package Arrays;
import java.util.Arrays;

public class MyArraysTest2
{
    public static void main(String[] args)
    {
        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        // Create
        Product[] products = { door, floorPanel };

        // Print
        System.out.println(Arrays.toString(products));

        // Add
        products = add(window, products);
        System.out.println(Arrays.toString(products));

        // Duplicates
        products = add(window, products);
        System.out.println(Arrays.toString(products));
       
    }

    private static Product[] add(Product product, Product[] array)
    {
        int length = array.length;
        Product[] newArray = Arrays.copyOf(array, length + 1); // you need to copy the array to a new array
        
        newArray[length] = product;
        return newArray;
    }

    // now take a look at the MyCollectionTest1.java
}
