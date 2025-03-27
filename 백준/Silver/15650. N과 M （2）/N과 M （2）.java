import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int m;
    private static int[] selected;
    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        selected = new int[m + 1];
        result = new StringBuilder();
        br.close();

        bt(0, 1);

        System.out.println(result);
    }

    private static void bt(int countOfSelected, int from) {
        if (countOfSelected == m) {
            for (int i = 0; i < m; i++) {
                result.append(selected[i]).append(' ');
            }
            result.append(System.lineSeparator());
            return;
        }

        for (int num = from; num <= n; num++) {
            selected[countOfSelected] = num;
            bt(countOfSelected + 1, num + 1);
        }
    }

}