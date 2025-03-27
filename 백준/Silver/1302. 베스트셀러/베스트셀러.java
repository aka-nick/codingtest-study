import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Map<String, Integer> frequancies = new HashMap<>();
        while (t-- > 0) {
            String bookName = br.readLine();
            frequancies.put(bookName, frequancies.getOrDefault(bookName, 0) + 1);
        }
        br.close();

        String mostFrequantBookName = frequancies.entrySet().stream()
                .sorted((b1, b2) -> {
                    if (!b1.getValue().equals(b2.getValue())) {
                        return b2.getValue() - b1.getValue();
                    } else {
                        return b1.getKey().compareTo(b2.getKey());
                    }
                })
                .findFirst()
                .get()
                .getKey();

        System.out.println(mostFrequantBookName);
    }

}