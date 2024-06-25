import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n-->0) {
            String word = br.readLine();
            String[] wordArr = word.split("");
            Deque<String> s = new ArrayDeque<>();
            for (int i = 0; i < wordArr.length; i++) {
                if (s.isEmpty() || !wordArr[i].equals(s.peekLast())) {
                    s.addLast(wordArr[i]);
                } else {
                    s.removeLast();
                }
            }
            if (s.isEmpty()) count++;
        }
        br.close();

        System.out.println(count);
    }
    
}