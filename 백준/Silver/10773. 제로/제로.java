import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> prices = new ArrayList<>();
        setPrices(br, n, prices);
        br.close();

        Deque<Integer> resultStack = new ArrayDeque<>();
        for (Integer price : prices) {
            if (price == 0) {
                if (!resultStack.isEmpty()) {
                    resultStack.pop();
                }
                continue;
            }

            resultStack.push(price);
        }

        long result = 0;
        for (Integer price : resultStack) {
            result += price;
        }

        System.out.println(result);
    }

    private static void setPrices(BufferedReader br, int n, List<Integer> prices)
            throws IOException {
        for (int i = 0; i < n; i++) {
            prices.add(Integer.parseInt(br.readLine()));
        }
    }
    
}
