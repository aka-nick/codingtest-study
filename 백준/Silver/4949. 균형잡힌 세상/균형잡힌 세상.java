import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    private static final char OPEN_BRACKET = '(';
    private static final char CLOSE_BRACKET = ')';
    private static final char OPEN_BIG_BRACKET = '[';
    private static final char CLOSE_BIG_BRACKET = ']';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<char[]> strings = new ArrayList<>();
        String line;
        while (!".".equals(line = br.readLine())) {
            strings.add(line.toCharArray());
        }
        br.close();

        StringBuilder result = new StringBuilder();
        Deque<Character> stack;
        for (int i = 0; i < strings.size(); i++) {
            stack = new ArrayDeque<>();
            char[] chars = strings.get(i);
            boolean isSuccess = true;
            for (char c : chars) {
                if (c != OPEN_BIG_BRACKET &&
                        c != OPEN_BRACKET &&
                        c != CLOSE_BIG_BRACKET &&
                        c!= CLOSE_BRACKET) {
                    continue;
                }
                if (c == OPEN_BRACKET || c == OPEN_BIG_BRACKET) {
                    stack.addLast(c);
                }
                else if (c == CLOSE_BRACKET) {
                    if (stack.isEmpty()) {
                        isSuccess = false;
                        break;
                    }
                    else if (stack.getLast() != OPEN_BRACKET) {
                        isSuccess = false;
                        break;
                    }
                    stack.pollLast();
                }
                else if (c == CLOSE_BIG_BRACKET) {
                    if (stack.isEmpty()) {
                        isSuccess = false;
                        break;
                    }
                    else if (stack.getLast() != OPEN_BIG_BRACKET) {
                        isSuccess = false;
                        break;
                    }
                    stack.pollLast();
                }
            }
            if (!stack.isEmpty()) {
                isSuccess = false;
            }

            if (isSuccess) {
                result.append("yes").append(System.lineSeparator());
            }
            else {
                result.append("no").append(System.lineSeparator());
            }
        }

        System.out.println(result);
    }

}