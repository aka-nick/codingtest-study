import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for (char c : s.toCharArray()) {
			
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
			else if (c == ')' || c == '}' || c == ']') {
				if (stack.size() == 0) return false;
				
				char top = stack.peek();
				
				if (stack.size() == 0) return false;
				else if (top != '(' && top != '{' && top != '[') return false;
				
				if (c == ')' && top == '(' 
						|| c == '}' && top == '{'
						|| c == ']' && top == '[') 
					stack.pop();
				else 
					return false;
				
			}
		}
		
		return stack.size() == 0 ? true : false;
    }
}