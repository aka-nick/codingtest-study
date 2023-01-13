import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (0 < testcaseNumber--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); // 찾고 싶은 문서의 idx값
            Deque<Document> printerQ = new ArrayDeque<>();
            PriorityQueue<Document> orderQ = new PriorityQueue<>((o1, o2) -> o2.priority - o1.priority);
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                Document doc = new Document(i, Integer.parseInt(st.nextToken()));
                printerQ.addLast(doc);
                orderQ.add(doc);
            }

            int printNumber = 0;
            while (!orderQ.isEmpty()) {
                Document printNow = orderQ.poll();
                while (!printerQ.isEmpty()) {
                    Document doc = printerQ.pollFirst();

                    if (doc.priority < printNow.priority) {
                        printerQ.addLast(doc);
                        continue;
                    }

                    printNumber++;

                    if (doc.idx == m) {
                        result.append(printNumber).append(System.lineSeparator());
                        printerQ.removeIf(o -> true);
                        orderQ.removeIf(o -> true);
                    }
                    else {
                        break;
                    }
                }
            }
        }
        br.close();
        System.out.println(result);
    }

    static class Document {
        int idx;
        int priority;

        public Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

}