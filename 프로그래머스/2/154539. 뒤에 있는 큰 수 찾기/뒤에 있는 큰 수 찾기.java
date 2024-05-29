import java.util.*;

class Solution {
    
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0);
        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        
        return result;
    }
    
    /*
    public int[] solution(int[] numbers) {
        return IntStream.range(0, numbers.length)
            .mapToObj(idx -> new int[]{idx, numbers[idx]})
            .mapToInt(pair -> Arrays.stream(numbers)
                    .skip(pair[0])
                    .filter(number -> pair[1] < number)
                    .findFirst()
                    .orElse(-1))
            .toArray();
    }
    */
    
    /*
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        answer[numbers.length - 1] = -1;
        
        for (int i = 0; i < numbers.length - 1; i++) {
            int base = numbers[i];
            
            for (int j = i + 1; j < numbers.length; j++) {
                int candidate = numbers[j];
                if (base < candidate) {
                    answer[i] = candidate;
                    break;
                }
            }
            
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
    */
    
}