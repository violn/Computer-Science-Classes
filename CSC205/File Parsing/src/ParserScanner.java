import java.io.File;
import java.util.Scanner;

public class ParserScanner {
    public static void main(String[] args) throws Exception {
        long start_time = System.currentTimeMillis();
        print();
        long elapse_time = System.currentTimeMillis() - start_time;
        System.out.println("Printing with Scanner in " + elapse_time + " miliseconds.");
    }

    public static void print() throws Exception {
        Scanner scan = new Scanner(new File("src\\Movies.txt"));
        String l;

        while (scan.hasNextLine()) {
            l = scan.nextLine();
            System.out.println(l);
        }

        scan.close();
    }
}
