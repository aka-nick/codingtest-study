import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();
        br.close();
        
        // 각 알파벳 자리수에 해당하는 배열을 만들고
        // 한 글자씩 등장할 때마다 해당 자리의 숫자를 ++한다.
        // 자리수 배열을 프린트하며 종료.
        
        int[] countOfAlphabets = new int[26];
        for (char c : word) {
            countOfAlphabets[getAsInt(c)]++;
        }

        StringBuilder result = new StringBuilder();
        for (int countOfAlphabet : countOfAlphabets) {
            result.append(countOfAlphabet).append(" ");
        }

        System.out.println(result);
    }

    private static int getAsInt(char c) {
        return c - 'a';
    }

}