import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] initials = new int[26];
        while (n-->0) {
            initials[br.readLine().charAt(0) - 'a']++;
        }
        br.close();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int initial = initials[i];
            if (5 <= initial) {
                result.append(Character.toChars(i + 'a'));
            }
        }

        System.out.println(result.length() == 0 ? "PREDAJA" : result);
    }

}