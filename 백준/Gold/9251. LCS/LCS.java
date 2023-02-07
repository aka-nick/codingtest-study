import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        int n = s1.length;
        int m = s2.length;
        br.close();

        int[][] mem = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if (s1[i - 1] == s2[j - 1]) { // 문자열 배열은 zerobased array
                    mem[i][j] = mem[i - 1][j - 1] + 1;
                }
                else {
                    mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
                }
            }
        }

        System.out.println(mem[n][m]);
    }
    
}