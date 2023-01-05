import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final String POSSIBLE = "Possible";
    private static final String IMPOSSIBLE = "Impossible";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] words = new String[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            words[i][0] = st.nextToken();
            words[i][1] = st.nextToken();
        }
        br.close();

        StringBuilder result = new StringBuilder();
        // n개의 문자열 셋트에 대하여
        for (int i = 0; i < words.length; i++) {
            // 첫번째 문자열의 알파벳 개수와 두번째 문자열의 알파벳 개수를 비교하여
            int[] freqOfAlphabet1 = getFreqOfAlphabet(words[i][0]);
            int[] freqOfAlphabet2 = getFreqOfAlphabet(words[i][1]);

            if (isSameWord(freqOfAlphabet1, freqOfAlphabet2)) {
                //  일치하면 Possible을 출력
                result.append(POSSIBLE);
            }
            else {
                //  상이하면 Impossible을 출력
                result.append(IMPOSSIBLE);
            }
            result.append(System.lineSeparator());
        }

        System.out.println(result);
    }

    private static boolean isSameWord(int[] word1, int[] word2) {
        for (int i = 0; i < word1.length; i++) {
            if (word1[i] != word2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getFreqOfAlphabet(String word) {
        int[] result = new int[26];
        for (char c : word.toCharArray()) {
            result[getAsInt(c)]++;
        }
        return result;
    }

    private static int getAsInt(char c) {
        return c - 'a';
    }
}