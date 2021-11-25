import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ParserList {
    public static void main(String[] args) throws Exception {
        long start_time = System.currentTimeMillis();
        print();
        long elapse_time = System.currentTimeMillis() - start_time;
        System.out.println("Printing with List in " + elapse_time + " miliseconds.");
    }

    public static void print() throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("src\\Movies.txt"));
        lines.forEach(System.out::println);
    }
}
