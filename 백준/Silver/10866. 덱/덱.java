import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final String PUSH_FRONT = "push_front";
    private static final String PUSH_BACK = "push_back";
    private static final String POP_FRONT = "pop_front";
    private static final String POP_BACK = "pop_back";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String FRONT = "front";
    private static final String BACK = "back";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<StringTokenizer> commands = new ArrayList<>();
        setCommands(br, n, commands);
        br.close();

        StringBuilder result = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        for (StringTokenizer commandToken : commands) {
            String command = commandToken.nextToken();

            if (PUSH_FRONT.equals(command)) {
                int data = Integer.parseInt(commandToken.nextToken());
                deque.addFirst(data);
            }
            else if (PUSH_BACK.equals(command)) {
                int data = Integer.parseInt(commandToken.nextToken());
                deque.addLast(data);
            }
            else if (POP_FRONT.equals(command)) {
                appendResult(result, deque.isEmpty() ? -1 : deque.pollFirst());
            }
            else if (POP_BACK.equals(command)) {
                appendResult(result, deque.isEmpty() ? -1 : deque.pollLast());
            }
            else if (SIZE.equals(command)) {
                appendResult(result, deque.size());
            }
            else if (EMPTY.equals(command)) {
                appendResult(result, deque.isEmpty() ? 1 : 0);
            }
            else if (FRONT.equals(command)) {
                appendResult(result, deque.isEmpty() ? -1 : deque.getFirst());
            }
            else if (BACK.equals(command)) {
                appendResult(result, deque.isEmpty() ? -1 : deque.getLast());
            }
        }

        System.out.println(result);
    }

    private static void appendResult(StringBuilder result, int data) {
        result.append(data).append(System.lineSeparator());
    }

    private static void setCommands(BufferedReader br, int n, List<StringTokenizer> commands)
            throws IOException {
        for (int i = 0; i < n; i++) {
            commands.add(new StringTokenizer(br.readLine()));
        }
    }
}