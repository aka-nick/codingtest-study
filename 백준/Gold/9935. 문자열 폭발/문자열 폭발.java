import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    private static final String DEFAULT_RESULT = "FRULA";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] exp = br.readLine().toCharArray();
        br.close();
        Deque<Character> dq = new ArrayDeque<>();
        char lastExp = exp[exp.length - 1];

        for (int i = 0; i < arr.length; i++) {
            char nowChar = arr[i];
            dq.addLast(nowChar);

            if (dq.size() < exp.length) {
                continue;
            }

            if (lastExp == dq.peekLast()) {
                char[] tmp = new char[exp.length];
                int loop = exp.length;
                while (loop-- > 0) {
                    tmp[loop] = dq.pollLast(); // 비교를 위해 일단 꺼내서
                }
                if (Arrays.compare(tmp, exp) == 0) { // 폭발물 발견: 다시 넣지 않음
                    continue;
                }
                for (char c : tmp) {
                    dq.addLast(c);
                }
            }

        }

        if (dq.isEmpty()) {
            System.out.println(DEFAULT_RESULT);
            return;
        }
        
        StringBuilder result = new StringBuilder();
        for (Character c : dq) {
            result.append(c);
        }

        System.out.println(result);
    }
}