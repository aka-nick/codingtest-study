import java.util.*;

class Solution {

    public int solution(int n, int k) {
        String convNum = Integer.toString(n, k);
        StringTokenizer st = new StringTokenizer(convNum, "0");
        List<Long> numbers = new ArrayList<>();
        
        while (st.hasMoreTokens()) {
            numbers.add(Long.valueOf(st.nextToken()));
        }
        
        int count = 0;
        for (Long number : numbers) {
            if (isPrime(number)) count++;
        }
        
        return count;
    }
    
    private boolean isPrime(Long number) {
        if (number < 2) {
            return false;
        }
        else if (number == 2) {
            return true;
        }
        else if (number % 2 == 0) {
            return false;
        }
        
        int max = (int) Math.sqrt(number);
        for (int i = 3; i <= max; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
}