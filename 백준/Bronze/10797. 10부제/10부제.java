import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int date = Integer.parseInt(br.readLine());
        int[] carNumber = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int nowCarNumber = carNumber[i];
            int nowCarLastNumber = nowCarNumber % 10;
            if (date == nowCarLastNumber) {
                count++;
            }
        }
        br.close();

        System.out.println(count);
    }

}