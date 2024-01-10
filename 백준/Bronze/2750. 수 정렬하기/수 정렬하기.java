import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        while (n-->0) {
            numbers.add(Integer.valueOf(br.readLine()));
        }
        br.close();

        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }

}