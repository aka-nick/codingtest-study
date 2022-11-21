class Solution {
    
    public int solution(int num) {
        
        if (num == 1) {
            return 0;
        }

        int count = 0;
        while (1 != num) {
            
            if (checkEndCondition(++count, num)) {
                count = -1;
                break;
            }
            
            num = doCollatz(num);
        }
        
        return count;
    }
    
    private int doCollatz(int num) {
        int result = 0;
        
        if (num % 2 == 0) {
            result = num / 2;
        }
        else {
            result = (num * 3) + 1;
        }
        
        return result;
    }
    
    private boolean checkEndCondition(int count, int num) {
        return 500 < count || num < 1;
    }
    
}