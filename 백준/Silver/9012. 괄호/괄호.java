import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        testcase:
        while (t-- > 0) {
            char[] chars = br.readLine().toCharArray();
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : chars) {
                if (c == OPEN) {
                    stack.addLast(c);
                }
                else {
                    if (stack.isEmpty()) {
                        saveNo(result);
                        continue testcase;
                    }
                    if (stack.peekLast() == OPEN) {
                        stack.pollLast();
                    }
                    else {
                        stack.addLast(c);
                    }
                }

            }
            if (!stack.isEmpty()) {
                saveNo(result);
                continue;
            }
            saveYes(result);
        }
        br.close();

        System.out.println(result);
    }

    private static void saveYes(StringBuilder result) {
        result.append("YES").append(System.lineSeparator());
    }

    private static void saveNo(StringBuilder result) {
        result.append("NO").append(System.lineSeparator());
    }
}