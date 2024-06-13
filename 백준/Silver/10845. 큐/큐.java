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
        while (n-->0) {
            String[] line = br.readLine().split(" ");
            String c = line[0];
            if ("push".equals(c)) {
                d.offer(Integer.parseInt(line[1]));
            } else if ("pop".equals(c)) {
                result.append(d.isEmpty() ? -1 : d.poll()).append(System.lineSeparator());
            } else if ("size".equals(c)) {
                result.append(d.size()).append(System.lineSeparator());
            } else if ("empty".equals(c)) {
                result.append(d.isEmpty() ? 1 : 0).append(System.lineSeparator());
            } else if ("front".equals(c)) {
                result.append(d.isEmpty() ? -1 : d.peekFirst()).append(System.lineSeparator());
            } else { // back
                result.append(d.isEmpty() ? -1 : d.peekLast()).append(System.lineSeparator());
            }
        }
        br.close();

        System.out.println(result);
    }

}