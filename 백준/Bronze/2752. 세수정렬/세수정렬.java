import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.stream(br.readLine().split(" "))
                .sorted(Comparator.comparingInt(Integer::parseInt))
                .forEach(i -> System.out.print(i + " "));
        br.close();
    }

}