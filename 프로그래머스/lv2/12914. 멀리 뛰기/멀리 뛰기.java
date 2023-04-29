class Solution {
    public long solution(int n) {
        long a = 1;
        long b = 1;
        for (int i = 1; i < n; i++) {
            long tmp = b;
            b = (a + b) % 1234567;
            a = tmp;
        }
        return b % 1234567;
    }
}