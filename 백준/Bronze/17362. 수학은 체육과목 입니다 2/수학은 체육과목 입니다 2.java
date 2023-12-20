import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int i = n % 8;
        if (i == 6) i = 4;
        if (i == 7) i = 3;
        if (i == 0) i = 2;

        System.out.println(i);
    }

}