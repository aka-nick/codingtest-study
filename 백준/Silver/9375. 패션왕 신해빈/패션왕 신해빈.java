import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> typeMap = new HashMap<>();
            while (n-->0) {
                String key = br.readLine().split(" ")[1];
                typeMap.put(key, typeMap.getOrDefault(key, 1) + 1);
            }
            int com = 1;
            for (String key : typeMap.keySet()) {
                com *= typeMap.get(key);
            }
            result.append(com - 1)
                    .append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}