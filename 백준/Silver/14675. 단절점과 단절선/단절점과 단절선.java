import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] ad = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            ad[i] = new ArrayList<>();
        }
        while (n-->1) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            ad[a].add(b);
            ad[b].add(a);
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (q-->0) {
            String[] tk = br.readLine().split(" ");
            int t = Integer.parseInt(tk[0]);
            int k = Integer.parseInt(tk[1]);

            if (t == 1) {
                if (1 < ad[k].size()) {
                    result.append("yes");
                } else {
                    result.append("no");
                }
            } else {
                result.append("yes");
            }
            result.append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}