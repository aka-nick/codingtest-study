import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (t-- > 0) {
            PriorityQueue<Integer> upperHeap = new PriorityQueue<>();
            PriorityQueue<Integer> lowerHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            int n = Integer.parseInt(br.readLine());
            result.append(System.lineSeparator()).append(n / 2 + 1).append(System.lineSeparator());
            StringTokenizer st = null;
            int line = 1;
            for (int i = 0; i < n; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int nowNumber = Integer.parseInt(st.nextToken());

                Integer upPeek = upperHeap.peek();
                if (upPeek == null || nowNumber <= upPeek) {
                    lowerHeap.offer(nowNumber);
                }
                else {
                    upperHeap.offer(nowNumber);
                }

                if (upperHeap.size() + 2 == lowerHeap.size()) {
                    upperHeap.offer(lowerHeap.poll());
                }
                else if (upperHeap.size() == lowerHeap.size() + 1) {
                    lowerHeap.offer(upperHeap.poll());
                }

                if (i % 2 == 0) {
                    line++;
                    result.append(lowerHeap.peek()).append(' ');
                    if ((line - 1) % 10 == 0) {
                        result.append(System.lineSeparator());
                    }
                }
            }
        }
        br.close();

        System.out.println(result.substring(1));
    }
}