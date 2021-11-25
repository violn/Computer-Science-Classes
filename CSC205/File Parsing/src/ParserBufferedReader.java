import java.io.BufferedReader;
import java.io.FileReader;

public class ParserBufferedReader {
    public static void main(String[] args) throws Exception {
        long start_time = System.currentTimeMillis();
        print();
        long elapsed_time = System.currentTimeMillis() - start_time;
        System.out.println("Printing with Buffered Reader in " + elapsed_time + " miliseconds.");
    }

    public static void print() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src\\Movies.txt"));
        String line = br.readLine();

        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }

        br.close();
    }
}