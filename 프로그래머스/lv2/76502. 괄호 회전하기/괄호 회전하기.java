import java.util.*;

class Solution {

    public int solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            dq.addLast(c);
        }
        
        int count = 0;
        int loop = s.length();
        while (loop-- > 0) {
            rotate(dq);
            if (isTrueBraket(dq)) count++;
        }
                
        return count;
    }
    
    private boolean isTrueBraket(Deque<Character> dq) {
        Deque<Character> checkStack = new ArrayDeque<>();
        for (Character pollChar : dq) {
            if (isOpener(pollChar)) {
                checkStack.addLast(pollChar);
            }
            else {
                if (checkStack.isEmpty()) {
                    return false;
                }
                else {
                    Character popChar = checkStack.pollLast();
                    if (!(isSmallPair(popChar, pollChar) ||
                       isMediumPair(popChar, pollChar) ||
                       isLargePair(popChar, pollChar))) {
                        return false;
                    }
                }
            }
        }
        if (!checkStack.isEmpty()) {
            return false;
        }
        
        return true;
    }
    private boolean isSmallPair(Character braket1, Character braket2) {
        return braket1 == '(' && braket2 == ')';
    }
    private boolean isMediumPair(Character braket1, Character braket2) {
        return braket1 == '[' && braket2 == ']';
    }
    private boolean isLargePair(Character braket1, Character braket2) {
        return braket1 == '{' && braket2 == '}';
    }
    private boolean isOpener(Character braket) {
        return braket == '(' || braket == '[' || braket == '{';
    }
    private void rotate(Deque<Character> dq) {
        dq.addLast(dq.pollFirst());
    }
    
    private void testPrint(Deque<Character> dq) {
        for (Character c : dq) {
            System.out.print(c);
        }
        System.out.println();
    }
}