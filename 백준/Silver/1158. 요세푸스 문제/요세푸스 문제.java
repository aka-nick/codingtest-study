import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        br.close();

        List<Integer> y = new LinkedList<>();
        IntStream.rangeClosed(1, n).forEach(y::add);
        StringBuilder result = new StringBuilder();

        int idx = 0;
        int count = 0;
        while (!y.isEmpty()) {
            count++;

            if (count == k) {
                result.append(y.remove(idx));
                if (!y.isEmpty()) {
                    result.append(", ");
                }
                count = 0;
                idx--;
            }

            idx++;

            if (y.size() <= idx) {
                idx = 0;
            }
        }

        System.out.println(result.append(">").insert(0, "<"));
    }

}