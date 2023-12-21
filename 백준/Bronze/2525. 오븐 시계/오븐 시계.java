import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] hm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int h = hm[0];
        int m = hm[1];
        int taken = Integer.parseInt(br.readLine());
        br.close();

        int resultM = (m + taken) % 60;
        int resultH = (h + (m + taken) / 60) % 24;

        System.out.println(resultH + " " + resultM);
    }

}