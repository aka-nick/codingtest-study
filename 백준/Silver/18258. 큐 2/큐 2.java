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
    private static final String FRONT = "front";
//    private static final String BACK = "back";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<StringTokenizer> commands = new ArrayList<>();
        setCommands(br, n, commands);
        br.close();

        StringBuilder result = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        for (StringTokenizer commandToken : commands) {
            String command = commandToken.nextToken();

            if (PUSH.equals(command)) {
                Integer input = Integer.valueOf(commandToken.nextToken());
                queue.addLast(input);
            }
            else if (POP.equals(command)) {
                if (!queue.isEmpty()) {
                    result.append(queue.removeFirst());
                }
                else {
                    result.append(-1);
                }
                result.append(System.lineSeparator());
            }
            else if (SIZE.equals(command)) {
                result.append(queue.size()).append(System.lineSeparator());
            }
            else if (EMPTY.equals(command)) {
                if (queue.isEmpty()) {
                    result.append(1);
                } else {
                    result.append(0);
                }
                result.append(System.lineSeparator());
            }
            else if (FRONT.equals(command)) {
                if (!queue.isEmpty()) {
                    result.append(queue.getFirst());
                }
                else {
                    result.append(-1);
                }
                result.append(System.lineSeparator());
            }
            else { // BACK.eq(command)
                if (!queue.isEmpty()) {
                    result.append(queue.getLast());
                }
                else {
                    result.append(-1);
                }
                result.append(System.lineSeparator());
            }
        }

        System.out.println(result);
    }

    private static void setCommands(BufferedReader br, int n, List<StringTokenizer> commands)
            throws IOException {
        for (int i = 0; i < n; i++) {
            commands.add(new StringTokenizer(br.readLine()));
        }
    }

}