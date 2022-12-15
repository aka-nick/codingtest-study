import java.util.Arrays;

class Solution {

    public int solution(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[a.length - i - 1];
        }

        return result;
    }

}