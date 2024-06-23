import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        char[] chars = br.readLine().toCharArray();
        for (char c : chars) {
            arr[c - 'A']++;
        }
        br.close();

        StringBuilder pre = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder post = new StringBuilder();
        boolean hasMid = false;
        char midChar = ' ';
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                continue;
            }

            if (arr[i] % 2 == 0) {
                String fix = Character.toString(i + 'A').repeat(arr[i] / 2);
                pre.append(fix);
                post.insert(0, fix);
            } else {
                if (!hasMid) {
                    hasMid = true;
                    midChar = (char)(i + 'A');
//                    mid.append(Character.toString(i + 'A').repeat(arr[i]));
                } else {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        }

        int offset = -1;
        if (hasMid) {
            for (int j = 0; j < pre.length(); j++) {
                if (midChar < pre.charAt(j)) {
                    offset = j;
                    break;
                }
            }

            if (-1 < offset) {
                String fix = Character.toString(midChar).repeat(arr[midChar - 'A'] / 2);
                pre.insert(offset, fix);
                post.insert(post.length() - offset, fix);
                mid.append(midChar);
            } else {
                mid.append(Character.toString(midChar).repeat(arr[midChar - 'A']));
            }
        }

        System.out.println(pre.append(mid).append(post));
    }

}