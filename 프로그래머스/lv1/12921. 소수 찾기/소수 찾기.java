import java.util.*;

class Solution {
    
    public int solution(int n) {
        
        int root = (int) Math.sqrt(n);
        boolean[] numbers = new boolean[n + 1];
        Arrays.fill(numbers, true);
        numbers[0] = false;
        numbers[1] = false;
        
        markPrimeNumber(root, numbers);
        
        return countPrimeNumber(numbers);
    }
    
    private void markPrimeNumber(int root, boolean[] numbers) {
        
        for (int i = 2; i <= root; i++) {
            if (numbers[i]) eraseBasicNumber(i, numbers);
        }
    }
    private void eraseBasicNumber(int number, boolean[] numbers) {
        
        for (int i = number * 2; i < numbers.length; i += number) {
            numbers[i] = false;
        }
    } 
    
    private int countPrimeNumber(boolean[] numbers) {
        
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]) result++;
        }
        return result;
    }
}