import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] houses;
    private static int left;
    private static int right;
    private static int n;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(houses);
        int min = houses[0];
        int max = houses[n - 1];

        left = 1;
        right = max - min;
        int mid = 0;

        while (left <= right) {

            mid = ((right - left) / 2) + left;

            if (canInstall(mid)) {
                left = mid + 1;
            }
            else {
                if (right <= mid) break;
                right = mid;
            }
        }

        System.out.println(left - 1);
    }

    private static boolean canInstall(int mid) {
        /*
        '최소요소(or 현재설치위치값) + p' 이상인 위치가 house에 존재하는지, 존재할 때마다 count.
        c <= count이면, return true. 아니면 false.
         */
        int count = 1;
        int now = houses[0];
        for (int i = 1; i < houses.length; i++) {
            if (now + mid <= houses[i]) {
                count++;
                now = houses[i];
            }
            if (count == c) return true;
        }
        return false;
    }
}