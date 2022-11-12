class Solution {
    public int solution(int a, int b, int n) {

        int result = 0;
        
        while (a <= n) {
            int left = n % a;
            int getNew = (n / a) * b;
            result += getNew;
            n = left + getNew;
        }
        
        return result;
    }
}