import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static final char OPEN_SMALL = '(';
    private static final char CLOSE_SMALL = ')';
    private static final char OPEN_BIG = '[';
    private static final char CLOSE_BIG = ']';
    private static final int NUMBER_SMALL = 2;
    private static final int NUMBER_BIG = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        br.close();

        Deque<Character> stack = new ArrayDeque<>();
        int sum = 0;
        int multiply = 1;
        for (int i = 0; i < chars.length; i++) {
            char now = chars[i];
            char before = 0 < i ? chars[i - 1] : ' ';

            if (now == OPEN_SMALL) {
                stack.addLast(now);
                multiply *= NUMBER_SMALL;
            }
            else if (now == OPEN_BIG) {
                stack.addLast(now);
                multiply *= NUMBER_BIG;
            }
            else if (isWrongCase(now, before, stack)) {
                System.out.println(0);
                return;
            }
            else if (now == CLOSE_SMALL) {
                if (before == OPEN_SMALL) {
                    sum += multiply;
                }
                if (!stack.isEmpty() && stack.getLast() == OPEN_SMALL) {
                    stack.pollLast();
                }
                multiply /= NUMBER_SMALL;
            }
            else if (now == CLOSE_BIG) {
                if (before == OPEN_BIG) {
                    sum += multiply;
                }
                if (!stack.isEmpty() && stack.getLast() == OPEN_BIG) {
                    stack.pollLast();
                }
                multiply /= NUMBER_BIG;
            }
        }

        if (isIncomplete(stack) || multiply != 1) {
            System.out.println(0);
            return;
        }

        System.out.println(sum);
    }

    private static boolean isIncomplete(Deque<Character> stack) {
        return !stack.isEmpty();
    }

    private static boolean isWrongCase(char now, char before, Deque<Character> stack) {
        return (now == CLOSE_SMALL && before == OPEN_BIG
                || now == CLOSE_BIG && before == OPEN_SMALL) ||
                stack.isEmpty() && (now == OPEN_SMALL || now == OPEN_BIG);
    }

}