import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final String PUSH = "push";
    private static final String POP = "pop";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String TOP = "top";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<StringTokenizer> commands = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            commands.add(new StringTokenizer(br.readLine()));
        }
        br.close();

        StringBuilder result = new StringBuilder();
        Deque<Integer> resultStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer lineToken = commands.get(i);
            String command = lineToken.nextToken(); // push X, pop, size, empty, top

            if (PUSH.equals(command)) {
                resultStack.push(Integer.valueOf(lineToken.nextToken()));
            }
            else if (POP.equals(command)) {
                if (resultStack.isEmpty()) {
                    append(-1, result);
                }
                else {
                    append(resultStack.pop(), result);
                }
            }
            else if (SIZE.equals(command)) {
                append(resultStack.size(), result);
            }
            else if (EMPTY.equals(command)) {
                if (resultStack.isEmpty()) {
                    append(1, result);
                }
                else {
                    append(0, result);
                }
            }
            else { // TOP.eq(command)
                Integer integer = resultStack.peek();
                if (integer == null) {
                    append(-1, result);
                }
                else {
                    append(integer, result);
                }
            }
        }

        System.out.println(result);
    }

    private static StringBuilder append(int data, StringBuilder result) {
        return result.append(data).append(System.lineSeparator());
    }

}