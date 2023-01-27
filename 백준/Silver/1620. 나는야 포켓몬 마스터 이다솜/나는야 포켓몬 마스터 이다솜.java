import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, String> numberMap = new HashMap<>();
        Map<String, Integer> nameMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String now = br.readLine();
            nameMap.put(now, i);
            numberMap.put(i, now);
        }
        List<String> commands = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            commands.add(br.readLine());
        }
        br.close();

        StringBuilder result = new StringBuilder();
        for (String command : commands) {
            if (Character.isAlphabetic(command.charAt(0))) {
                result.append(nameMap.get(command))
                        .append(System.lineSeparator());
            }
            else {
                result.append(numberMap.get(Integer.valueOf(command)))
                        .append(System.lineSeparator());
            }
        }

        System.out.println(result);
    }
}