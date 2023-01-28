import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> unheard = new TreeSet<>();
        Set<String> unseen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            unheard.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            unseen.add(br.readLine());
        }
        br.close();

        int count = 0;
        StringBuilder result = new StringBuilder();
        for (String uh : unheard) {
            if (unseen.contains(uh)) {
                count++;
                result.append(uh).append(System.lineSeparator());
            }
        }

        System.out.println(count);
        System.out.println(result);
    }
}