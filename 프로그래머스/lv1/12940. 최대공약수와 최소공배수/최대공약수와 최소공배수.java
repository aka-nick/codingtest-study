class Solution {
    public int[] solution(int n, int m) {
        int[] result = new int[2];
        
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        
        result[0] = gcd(max, min);
        result[1] = max * min / result[0];
        
        return result;
    }
    
    static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}