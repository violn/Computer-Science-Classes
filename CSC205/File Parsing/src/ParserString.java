import java.nio.file.Files;
import java.nio.file.Paths;
public class ParserString {
    public static void main(String[] args) throws Exception 
    {
        long start_time = System.currentTimeMillis();
        print();
        long elapse_time = System.currentTimeMillis() - start_time;
        System.out.println("Printing with String in " + elapse_time + " miliseconds.");
    }

    public static void print() throws Exception {
        String file = new String(Files.readAllBytes(Paths.get("src\\Movies.txt")));
        System.out.println(file);
    }
}
