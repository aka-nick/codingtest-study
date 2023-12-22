import java.io.*;
import java.util.*;

public class Main {

    public static final int[] X_ARR = new int[1001];
    public static final int[] Y_ARR = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 3;
        while (n-->0) {
            int[] point = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            checkX(point[0]);
            checkY(point[1]);
        }
        br.close();

        System.out.println(getXPoint() + " " + getYPoint());
    }


    private static void checkX(int x) {
        if (X_ARR[x] == 0) {
            X_ARR[x]++;
            return;
        }
        X_ARR[x]--;
    }
    private static void checkY(int y) {
        if (Y_ARR[y] == 0) {
            Y_ARR[y]++;
            return;
        }
        Y_ARR[y]--;
    }
    private static int getXPoint() {
        for (int i = 0; i < X_ARR.length; i++) {
            if (X_ARR[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int getYPoint() {
        for (int i = 0; i < Y_ARR.length; i++) {
            if (Y_ARR[i] == 1) {
                return i;
            }
        }
        return -1;
    }

}