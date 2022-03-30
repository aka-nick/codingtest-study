class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        boolean isEven;
        
        for (int i = left; i <= right; i += 1) {
            isEven = true;
            
            for (int j = 1; j <= i; j += 1) {
                isEven = (i % j) == 0 ? !isEven : isEven;
            }
            answer += isEven ? i : -i;
        }
        
        return answer;
    }
}