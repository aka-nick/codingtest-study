import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> as = getInts(br, n);
        List<Integer> bs = getInts(br, n);
        as.sort(((o1, o2) -> o1 - o2));
        bs.sort(((o1, o2) -> o2 - o1));
        br.close();
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += as.get(i) * bs.get(i);
        }

        System.out.println(sum);
    }

    private static List<Integer> getInts(BufferedReader br, int n) throws IOException {
        List<Integer> ints = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints.add(Integer.parseInt(st.nextToken()));
        }
        
        return ints;
    }
}