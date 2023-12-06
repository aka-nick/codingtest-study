import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        String space = " ";
        String star = "*";
        for (int i = 1; i <= n; i++) {
            System.out.println(space.repeat(n - i) + star.repeat(i));
        }
    }

}