class Solution {
    boolean solution(String s) {
        char[] lower = s.toLowerCase().toCharArray();
        
        int balance = 0;
        for (char l : lower) {
            if (l == 'p') balance--;
            else if (l == 'y') balance++;
        }
        
        return balance == 0;
    }
}