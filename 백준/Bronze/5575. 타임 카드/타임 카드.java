import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] b = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] c = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();

        System.out.println(getTime(getSecond(a[3], a[4], a[5]) - getSecond(a[0], a[1], a[2])));;
        System.out.println(getTime(getSecond(b[3], b[4], b[5]) - getSecond(b[0], b[1], b[2])));;
        System.out.println(getTime(getSecond(c[3], c[4], c[5]) - getSecond(c[0], c[1], c[2])));;
    }

    private static int getSecond(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    private static String getTime(int second) {
        int h = second / 3600;
        int m = second % 3600 / 60;
        int s = second % 3600 % 60;
        return String.format("%d %d %d", h, m, s);
    }


}