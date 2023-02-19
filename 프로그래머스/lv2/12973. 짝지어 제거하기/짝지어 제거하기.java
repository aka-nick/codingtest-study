import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            
            // 비교할 글자가 없는 첫글자의 경우
            if (stack.isEmpty()) {
                stack.addLast(c);
                continue;
            }
            
            // 같은 문자열이 발견되는 경우
            if (stack.peekLast() == c) {
                stack.pollLast();
                continue;
            }
            
            stack.addLast(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}