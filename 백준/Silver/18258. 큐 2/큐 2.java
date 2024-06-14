import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> d = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        while (n-->0) {
            String[] line = br.readLine().split(" ");
            String com = line[0];
            if (com.equals("push")) {
                d.offer(Integer.parseInt(line[1]));
            } else if (com.equals("pop")) {
                result.append(d.isEmpty() ? -1 : d.pop()).append(System.lineSeparator());
            } else if (com.equals("size")) {
                result.append(d.size()).append(System.lineSeparator());
            } else if (com.equals("empty")) {
                result.append(d.isEmpty() ? 1 : 0).append(System.lineSeparator());
            } else if (com.equals("front")) {
                result.append(d.isEmpty() ? -1 : d.peek()).append(System.lineSeparator());
            } else { // back
                result.append(d.isEmpty() ? -1 : d.peekLast()).append(System.lineSeparator());
            }
        }
        br.close();

        System.out.println(result);
    }

}