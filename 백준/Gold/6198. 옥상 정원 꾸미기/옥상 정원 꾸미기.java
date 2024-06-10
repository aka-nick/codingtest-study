import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            heights.add(Integer.valueOf(br.readLine()));

        }
        br.close();

        long count = 0L;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= heights.get(i)) {
                stack.pop();
            }

            count += stack.size();
            stack.push(heights.get(i));
        }

        System.out.println(count);
    }

}