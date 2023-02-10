import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int bitSet = 0;
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("all")) {
                bitSet |= ~0;
            } else if (command.equals("empty")) {
                bitSet &= 0;
            } else {
                int comNum = Integer.parseInt(st.nextToken());
                if (command.equals("add")) {
                    bitSet |= (1 << (comNum - 1));
                } else if (command.equals("remove")) {
                    bitSet = bitSet & ~(1 << (comNum - 1));
                } else if (command.equals("check")) {
                    result.append((bitSet & (1 << (comNum - 1))) == 0 ? "0\n" : "1\n");
                } else if (command.equals("toggle")) {
                    bitSet ^= (1 << (comNum - 1));
                }
            }
        }
        br.close();

        System.out.println(result);
    }

}