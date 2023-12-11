import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(l - Math.max(calc(a, c), calc(b, d)));
    }

    private static int calc(int totalPage, int pagePerDay) {
        return totalPage / pagePerDay + (totalPage % pagePerDay != 0 ? 1 : 0);
    }

}