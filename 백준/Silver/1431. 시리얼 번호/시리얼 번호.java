import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<char[]> serials = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            serials.add(br.readLine().toCharArray());
        }
        br.close();

        StringBuilder result = new StringBuilder();
        serials.stream()
                .sorted((o1, o2) -> {
                    if (o1.length != o2.length) {
                        return o1.length - o2.length;
                    }

                    int sum1 = 0;
                    for (char c : o1) {
                        if (Character.isDigit(c)) {
                            sum1 += Character.digit(c, 10);
                        }
                    }
                    int sum2 = 0;
                    for (char c : o2) {
                        if (Character.isDigit(c)) {
                            sum2 += Character.digit(c, 10);
                        }
                    }
                    if (sum1 != sum2) {
                        return sum1 - sum2;
                    }

                    String s1 = new String(o1);
                    String s2 = new String(o2);
                    return s1.compareTo(s2);
                })
                .forEach(o -> result.append(o).append(System.lineSeparator()));

        System.out.println(result);
    }
}