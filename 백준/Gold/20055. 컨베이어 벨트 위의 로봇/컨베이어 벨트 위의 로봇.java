import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> durability = new LinkedList<>();
        List<Boolean> robots = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            durability.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < n; i++) {
            robots.add(false);
        }

        int round = 0;
        while (true) {
            round++;

            // step 1
            durability.add(0, durability.remove(2 * n - 1));
            for (int i = n - 2; 0 <= i; i--) {
                robots.set(i + 1, robots.get(i));
                robots.set(i, false);
            }
            robots.set(n - 1, false);

            // step 2
            for (int idx = n - 2; 0 <= idx; idx--) {
                Boolean now = robots.get(idx);
                int nextIdx = idx + 1;

                if (!now) continue;
                int nextDurability = durability.get(nextIdx);
                if (nextDurability == 0) continue;
                if (robots.get(nextIdx)) continue;

                robots.set(nextIdx, true);
                robots.set(idx, false);
                durability.set(nextIdx, --nextDurability);
            }
            robots.set(n - 1, false);

            // step 3
            int firstDurability = durability.get(0);
            if (0 < firstDurability) {
                durability.set(0, --firstDurability);
                robots.set(0, true);
            }

            // step 4
            int exitFlag = 0;
            for (Integer d : durability) {
                if (d == 0) exitFlag++;
            }
            if (k <= exitFlag) {
                System.out.println(round);
                return;
            }
        }
    }

}