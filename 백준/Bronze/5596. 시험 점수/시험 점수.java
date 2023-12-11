import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        br.close();

        System.out.println(Math.max(getTotal(s), getTotal(t)));
    }

    private static int getTotal(String scores) {
        return Arrays.stream(scores.split(" "))
                .mapToInt(Integer::parseInt)
                .sum();
    }

}