import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input1 = br.readLine().toCharArray();
        char[] input2 = br.readLine().toCharArray();
        br.close();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (char c : input1) {
            arr1[c - 'a']++;
        }

        for (char c : input2) {
            if (0 < arr1[c - 'a']) arr1[c - 'a']--;
            else arr2[c - 'a']++;
        }

        int result = 0;
        for (int i : arr1) {
            result += i;
        }
        for (int i : arr2) {
            result += i;
        }

        System.out.println(result);
    }

}