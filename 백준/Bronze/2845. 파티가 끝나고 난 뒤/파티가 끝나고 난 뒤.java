import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] lp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] visitor = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();

        int guess = lp[0] * lp[1];

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < visitor.length; i++) {
            int now = visitor[i];
            result.append(now - guess).append(" ");
        }
        System.out.println(result);
    }

}