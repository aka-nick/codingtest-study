import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        Deque<Integer> d = new ArrayDeque<>();
        int last = 0;
        while (n-- > 0) {
            int number = Integer.parseInt(br.readLine());

            if (last < number) {
                for (int i = last + 1; i <= number; i++) {
                    d.push(i);
                    result
                            .append("+")
                            .append(System.lineSeparator());
                }
                last = number;
            }
            else if (!d.isEmpty() && d.peek() != number) {
                System.out.println("NO");
                return;
            }

            d.pop();
            result
                    .append("-")
                    .append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}