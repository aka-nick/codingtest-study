class Solution {
    public long solution(int a, int b) {
        if (a == b) return a; 
        else if (a > b) a ^= b ^ (b = a);
        if (b - a == 1) return a + b;
        
        int half = (b - a) / 2;
        long apb = a + b;
        if (a + half == b - half) 
            return apb * half + (half + a);
        else 
            return apb * (half + 1);
    }
}