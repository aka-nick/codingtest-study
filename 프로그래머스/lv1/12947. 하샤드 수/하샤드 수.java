class Solution {
    public boolean solution(int x) {
        
        int sum = 0;
        if (x <= 10) {
            return true;
        }
        
        String xString = String.valueOf(x);
        for (int i = 0; i < xString.length(); i++) {
            sum += xString.charAt(i) - '0';
        }
        
        return x % sum == 0;
    }
}