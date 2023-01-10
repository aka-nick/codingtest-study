import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<char[]> strings = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            strings.add(br.readLine().toCharArray());
        }
        br.close();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            int sum = 0;
            int tmp = 1;

            char[] chars = strings.get(i);
            for (char c : chars) {
                if (c == 'O') {
                    sum += tmp++;
                }
                else {
                    tmp = 1;
                }
            }
            result.append(sum).append(System.lineSeparator());
        }

        System.out.println(result);
    }

}