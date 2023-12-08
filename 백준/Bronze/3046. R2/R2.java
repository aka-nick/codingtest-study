import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] R1AndS = br.readLine().split(" ");
        br.close();
        int r1 = Integer.parseInt(R1AndS[0]);
        int s = Integer.parseInt(R1AndS[1]);
        int r2 = getR2(r1, s);

        System.out.println(r2);
    }

    private static int getR2(int r1, int s) {
        return s * 2 - r1;
    }

}