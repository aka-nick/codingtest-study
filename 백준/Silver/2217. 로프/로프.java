import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> ropes = getRopes(br, n);
        br.close();

        int maxWeight = getMaxWeight(ropes);

        System.out.println(maxWeight);
    }

    private static int getMaxWeight(List<Integer> ropes) {
        int maxWeight = -1;
        for (int i = 1; i <= ropes.size(); i++) {
            maxWeight = Math.max(maxWeight, ropes.get(i - 1) * i);
        }
        return maxWeight;
    }

    private static List<Integer> getRopes(BufferedReader br, int n) throws IOException {
        List<Integer> ropes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ropes.add(Integer.valueOf(br.readLine()));
        }
        ropes.sort(((o1, o2) -> o2 - o1));
        return ropes;
    }

}