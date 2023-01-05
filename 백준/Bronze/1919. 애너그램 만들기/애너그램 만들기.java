import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();
        br.close();

        int[] count1 = getIntArray(word1);
        int[] count2 = getIntArray(word2);

        int diffSum = 0;
        for (int i = 0; i < 26; i++) {
            diffSum += Math.abs(count1[i] - count2[i]);
        }

        System.out.println(diffSum);
    }

    private static int[] getIntArray(char[] word) {
        int[] result = new int[26];
        for (int i = 0; i < word.length; i++) {
            result[getAnInt(word[i])]++;
        }
        return result;
    }

    private static int getAnInt(char word) {
        return word - 'a';
    }

}
