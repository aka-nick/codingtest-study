class Solution {
    public boolean solution(String s) {
        
        int length = s.length();
        
        if (!(length == 4 || length == 6)) return false;
        
        for (char c : s.toCharArray()) {
            if (c - '0' < 0 || 9 < c - '9') {
                return false;
            }
        }
        
        return true;
    }
}