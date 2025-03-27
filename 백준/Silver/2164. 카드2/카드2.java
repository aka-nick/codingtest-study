import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        br.close();

        Deque<Integer> numbers = new ArrayDeque<>();
        for (int i = 1; i <= number; i++) {
            numbers.addLast(i);
        }

        while (true) {
            Integer removed = numbers.removeFirst();
            if (numbers.isEmpty()) {
                System.out.println(removed);
                break;
            }
            numbers.addLast(numbers.removeFirst());
        }
    }

}