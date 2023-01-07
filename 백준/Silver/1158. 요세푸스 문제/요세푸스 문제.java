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

        ListIterator<Integer> numbers = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toList())
                .listIterator(0);

        StringBuilder result = new StringBuilder("<");
        int compareCount = 0;
        while (numbers.hasNext()) {
            // k번 만큼 next()
            compareCount++;
            if (compareCount < k) {
                numbers.next();
            }

            // k번째에는 remove를 실행해준다. 지워지는 녀석들은 수열에 기록.
            else if (compareCount == k) {
                result.append(numbers.next()).append(", ");
                numbers.remove();
                compareCount = 0;
            }

            // hasNext()가 false면 0으로 돌려놓는다
            if (!numbers.hasNext()) {
                while (numbers.hasPrevious()) {
                    numbers.previous();
                }
            }
        }
        result.replace(result.length() - 2, result.length(), ">");

        System.out.println(result);
    }

}