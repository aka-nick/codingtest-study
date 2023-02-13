import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        while (n-- > 0) {
            numbers.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        PriorityQueue<Integer> upperHeap = new PriorityQueue<>();
        PriorityQueue<Integer> lowerHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);

            // upperHeap의 peek와 비교하여
            //  같거나 작으면 lowerHeap에 offer(), 아니면 upperHeap에 offer()한다.
            if (upperHeap.peek() == null ||
                    number <= upperHeap.peek()) {
                lowerHeap.offer(number);
            }
            else {
                upperHeap.offer(number);
            }

            // 힙 사이즈에 따라 재배치: 사이즈는 중간값을 담고 있는 lowerHeap이 1 크거나 같아야 한다.
            if (upperHeap.size() + 2 == lowerHeap.size()) {
                upperHeap.offer(lowerHeap.poll());
            }
            else if (upperHeap.size() == lowerHeap.size() + 1) {
                lowerHeap.offer(upperHeap.poll());
            }

            result.append(lowerHeap.peek()).append(System.lineSeparator());
        }

        System.out.println(result);
    }

}