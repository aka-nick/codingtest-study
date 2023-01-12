import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> words = new HashSet<>();
        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }
        br.close();

        StringBuilder result = new StringBuilder();
        words.stream()
                .sorted((o1, o2) -> o1.length() == o2.length()
                        ? o1.compareTo(o2) : o1.length() - o2.length())
                .forEach(System.out::println);
    }

}