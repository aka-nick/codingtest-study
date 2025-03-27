import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int count = 0;
        while (t-- > 0) {
            char[] chars = br.readLine().toCharArray();

            Deque<Character> dq = new ArrayDeque<>();
            dq.addLast(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                if (!dq.isEmpty() && dq.peekLast() == chars[i]) {
                    dq.removeLast();
                } else {
                    dq.addLast(chars[i]);
                }
            }

            if (dq.isEmpty()) {
                count++;
            }
        }
        br.close();

        System.out.println(count);
    }

}