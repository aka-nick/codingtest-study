import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.valueOf(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> finds = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            finds.add(Integer.valueOf(st.nextToken()));
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (Integer find : finds) {
            if (set.contains(find)) {
                sb.append(1);
            }
            else {
                sb.append(0);
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}