class Solution {
    public int solution(int n) {
        int a = 1;
        int b = 1;
        for (int i = 1; i < n; i++) {
            int tmp = a;
            a = b;
            b += tmp;
            b %= 1_000_000_007;
        }
        return b;
    }
}