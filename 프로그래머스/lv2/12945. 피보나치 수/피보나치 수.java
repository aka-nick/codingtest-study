class Solution {
    public int solution(int n) {
        long a = 1L;
        long b = 1L;
        for (long i = 2; i < n; i++) {
            long fibo = a + b;
            a = b;
            b = fibo % 1234567;
        }
        return Long.valueOf(b).intValue();
    }
}