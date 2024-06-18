import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        br.close();

        StringBuilder result = new StringBuilder();
        for (char codePoint : line.toCharArray()) {
            int encryptedCodePoint = -1;
            if (('a' <= codePoint && codePoint <= 'z')
                    || ('A' <= codePoint && codePoint <= 'Z')) {
                int encryptChar = codePoint + 13;
                if (('a' <= codePoint && codePoint <= 'z')
                        && ('z' < encryptChar)) {
                    encryptedCodePoint = encryptChar - 26;
                } else if (('A' <= codePoint && codePoint <= 'Z')
                        && ('Z' < encryptChar)) {
                    encryptedCodePoint = encryptChar - 26;
                } else {
                    encryptedCodePoint = encryptChar;
                }
            } else {
                encryptedCodePoint = codePoint;
            }
            String encryptedChar = Character.toString(encryptedCodePoint);
            result.append(encryptedChar);
        }

        System.out.println(result);
    }

}