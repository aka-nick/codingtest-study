import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[] ascArr = new int[n];
        ascArr[0] = 1;
        for (int i = 0; i < n; i++) {
            int now = arr[i];
            int idx = i;
            int largestValueForUpdate = -1;
            while (idx-- > 0) {
                int pre = arr[idx];
                if (pre < now) {
                    if (largestValueForUpdate < ascArr[idx] + 1) {
                        largestValueForUpdate = ascArr[idx] + 1;
                    }
                }
            }

            ascArr[i] = largestValueForUpdate == -1 ? 1 : largestValueForUpdate;
        }

        int[] descArr = new int[n];
        descArr[n - 1] = 1;
        for (int i = n - 1; 0 <= i; i--) {
            int now = arr[i];
            int idx = i;
            int largestValueForUpdate = -1;
            while (++idx < n) {
                int pre = arr[idx];
                if (pre < now) {
                    if (largestValueForUpdate < descArr[idx] + 1) {
                        largestValueForUpdate = descArr[idx] + 1;
                    }
                }
            }

            descArr[i] = largestValueForUpdate == -1 ? 1 : largestValueForUpdate;
        }

        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (answer < ascArr[i] + descArr[i]) {
                answer = ascArr[i] + descArr[i];
            }
        }

        System.out.println(answer - 1);
    }

}