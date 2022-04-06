import java.util.Stack;

class Solution {

    public String minRemoveToMakeValid(String s) {
		
		Stack<Character> parenStack = new Stack<Character>();
		char[] sArr = s.toCharArray();
		int[] leftParenArr = new int[sArr.length];
		for (int i = 0; i < leftParenArr.length; i += 1) leftParenArr[i] = -1;
		
		for (int i = 0, leftParenIdx = -1; i < sArr.length; i += 1) {
			if (sArr[i] == '(') {
				parenStack.push(sArr[i]);
				
				leftParenIdx += 1;
				leftParenArr[leftParenIdx] = i;
			}
			else if (sArr[i] == ')') {
				if (parenStack.size() == 0) {
					sArr[i] = '*';
					continue;
				}
				
				parenStack.pop();
				
				leftParenArr[leftParenIdx] = -1;
				leftParenIdx -= 1;
				
			}
		}
		
		for (int i = 0; i < leftParenArr.length; i += 1) {
			if (leftParenArr[i] == -1) break;
			
			sArr[leftParenArr[i]] = '*';
		}
		
		return new String(sArr).replace("*", "");
		
	}
    
}