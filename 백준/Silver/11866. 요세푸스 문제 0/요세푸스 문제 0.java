import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();

        ListIterator<Integer> it = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toList())
                .listIterator(0);
        StringBuilder result = new StringBuilder("<");

        int count = 0;
        while (it.hasNext()) {
            count++;
            if (count < k) {
                it.next();
            }
            else {
                result.append(it.next()).append(", ");
                it.remove();
                count = 0;
            }

            if (!it.hasNext()) {
                rewindIndex(it);
            }
        }

        result.replace(result.length() - 2, result.length(), ">");

        System.out.println(result);
    }

    private static void rewindIndex(ListIterator<Integer> it) {
        while (it.hasPrevious()) {
            it.previous();
        }
    }

}