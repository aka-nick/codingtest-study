import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int a = Integer.parseInt(first[0]);
        int b = Integer.parseInt(first[1]);
        String[] second = br.readLine().split(" ");
        int c = Integer.parseInt(second[0]);
        int d = Integer.parseInt(second[1]);
        br.close();

        System.out.println(Math.min((a + d), (b + c)));
    }

}