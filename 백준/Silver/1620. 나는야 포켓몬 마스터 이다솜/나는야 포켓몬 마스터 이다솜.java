import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        
        HashMap<String, Integer> nameNumber = new HashMap<>();
        HashMap<Integer, String> numberName = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            numberName.put(i, name);
            nameNumber.put(name, i);
        }

        StringBuilder result = new StringBuilder();
        while (m-->0) {
            String nameOrNumber = br.readLine();
            char c = nameOrNumber.charAt(0);
            if (Character.isAlphabetic(c)) {
                result.append(nameNumber.get(nameOrNumber));
            } else {
                result.append(numberName.get(Integer.valueOf(nameOrNumber)));
            }
            result.append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}