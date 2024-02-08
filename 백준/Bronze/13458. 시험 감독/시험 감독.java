import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] bc = br.readLine().split(" ");
        int b = Integer.parseInt(bc[0]);
        int c = Integer.parseInt(bc[1]);
        br.close();
        
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            int nowA = a[i];
            nowA-=b;
            count++;
            if (nowA <= 0) {
                continue;
            }

            if (nowA % c != 0) {
                count++;
            }
            count += (nowA / c);
        }

        System.out.println(count);
    }

}