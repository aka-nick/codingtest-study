import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        Deque<Integer> deck = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deck.addLast(i);
        }

        while (1 < deck.size()) {
            deck.removeFirst();
            deck.addLast(deck.removeFirst());
        }

        System.out.println(deck.getFirst());
    }
}