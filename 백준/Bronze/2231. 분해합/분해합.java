import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 0; i < n; i++) {
            int digitSum = getDigitSum(i);
            if (n == digitSum + i) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

    private static int getDigitSum(int i) {
        int digitSum = 0;
        for (char numChar : String.valueOf(i).toCharArray()) {
            digitSum += Character.getNumericValue(numChar);
        }
        return digitSum;
    }

}