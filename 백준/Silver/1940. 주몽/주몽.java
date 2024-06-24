import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 재료개수
        int m = Integer.parseInt(br.readLine()); // 갑옷 필요수
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        br.close();

        int s = 0;
        int e = arr.length - 1;
        int count = 0;
        while (s < e) {
            if (arr[s] + arr[e] < m) {
                s++;
            } else if (arr[s] + arr[e] == m) {
                e--;
                count++;
            } else {
                e--;
            }
        }
        System.out.println(count);
    }

}