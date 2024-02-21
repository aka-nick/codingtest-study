import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = br.readLine().chars()
                .mapToObj(c -> c - '0')
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        result.append(Integer.toBinaryString(numbers.get(0)));

        for (int i = 1; i < numbers.size(); i++) {
            String tmp = Integer.toBinaryString(numbers.get(i));
            while (tmp.length() < 3) {
                tmp = "0" + tmp;
            }
            result.append(tmp);
        }

        System.out.println(result);
    }

}