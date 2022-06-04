import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];

        bt(n, m, 1, 0, arr);

    }

    private static void bt(int n, int m, int start, int depth, int[] arr) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        int nowLength = n - start + m;
        if (nowLength < m) return;
        for (int i = start; i <= n; i++) {
                arr[depth] = i;
                bt(n, m, i + 1, depth + 1, arr);
        }
    }
}