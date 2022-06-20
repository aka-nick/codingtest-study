import java.util.Stack;

class Solution {
   boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack.push(c);
            }
            else { // ')'
                if (stack.isEmpty()) return false;

                char popc = stack.pop();
                if (popc != '(') return false;
            }

        }

        if (!stack.isEmpty()) return false;

        return true;

    }
}