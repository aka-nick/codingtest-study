import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        br.close();

        int[] counts = new int[26];
        Arrays.fill(counts, -1);

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (counts[c - 'a'] == -1) {
                counts[c - 'a'] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int count : counts) {
            result.append(count).append(" ");
        }
        System.out.println(result);
    }
}