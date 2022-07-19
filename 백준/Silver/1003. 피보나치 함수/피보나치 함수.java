import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] mem;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] tArr = new int[t];
        int maxT = -1;
        for (int i = 0; i < t; i++) {
            tArr[i] = Integer.parseInt(br.readLine());
            maxT = Math.max(maxT, tArr[i]);
        }
        br.close();

        mem = new int[maxT + 1];
        mem[0] = 0;
        if (1 <= maxT) mem[1] = 1;
        for (int i = 2; i <= maxT; i++) {
            mem[i] = mem[i - 2] + mem[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] == 0) {
                sb.append("1 0\n");
            }
            else {
                sb.append(mem[tArr[i] - 1]).append(' ').append(mem[tArr[i]]).append(System.lineSeparator());
            }
        }

        System.out.println(sb.toString());
    }

}
