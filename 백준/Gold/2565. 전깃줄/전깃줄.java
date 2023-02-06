import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Wire> wires = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            wires.add(new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        br.close();

        wires.sort((o1, o2) -> o1.start - o2.start);

        int[] mem = new int[n];
        Arrays.fill(mem, 1);
        for (int i = 0; i < n; i++) {
            Wire nowWire = wires.get(i);
            for (int j = 0; j < i; j++) {
                Wire beforeWire = wires.get(j);

                if (beforeWire.end < nowWire.end) {
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }
        }

        int available = -1;
        for (int i : mem) {
            available = Math.max(available, i);
        }
        System.out.println(n - available);
    }

    static class Wire {
        int start;
        int end;

        public Wire(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}