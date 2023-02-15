import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                result.append("1 1").append(System.lineSeparator());
                continue;
            }

            int[] apb = new int[26];
            for (char c : w.toCharArray()) {
                apb[c - 'a']++;
            }

            int minLen = 100000;
            int maxLen = -1;

            for (int pointOfRef = 0; pointOfRef < w.length(); pointOfRef++) {
                char findChar = w.charAt(pointOfRef);
                if (apb[findChar - 'a'] < k) continue;

                int appeared = 1;
                for (int lenOfIncrease = pointOfRef + 1; lenOfIncrease < w.length(); lenOfIncrease++) {

                    if (findChar == w.charAt(lenOfIncrease)) appeared++;
                    if (appeared == k) {
                        minLen = Math.min(minLen, lenOfIncrease - pointOfRef + 1);
                        maxLen = Math.max(maxLen, lenOfIncrease - pointOfRef + 1);
                        break;
                    }
                }
            }

            if (maxLen == -1) {
                result.append(-1).append(System.lineSeparator());
            }
            else {
                result.append(minLen).append(' ').append(maxLen).append(System.lineSeparator());
            }
        }
        br.close();

        System.out.println(result);
    }

}