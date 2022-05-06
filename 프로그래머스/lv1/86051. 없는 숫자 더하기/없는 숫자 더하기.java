class Solution {
    public int solution(int[] numbers) {        
        int result = 45; // sum 1~9
        
        for (int number : numbers) result -= number;
        
        return result;
    }   
}