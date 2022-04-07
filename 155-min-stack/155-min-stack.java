import java.util.EmptyStackException;

class MinStack {

    class Node {
		private int min;
		private int data;
		private Node prev;
		
		public Node(int val) {
			data = val;
		}
	}
	
	private Node top;
	
	public MinStack() {
	}
	
	public void push(int val) {
		Node newNode = new Node(val);
		
		if (top == null) {
			newNode.min = val;
			
			top = newNode;
		}
		else {
			if (top.min > val) 
				newNode.min = val;
			else 
				newNode.min = top.min;
			
			newNode.prev = top;
			top = newNode;
		}
		
	}
	
	public void pop() {
		if (top == null) throw new EmptyStackException();
		
		top = top.prev;
	}
	
	public int top() {
		if (top == null) throw new EmptyStackException();
		
		return top.data;
	}
	
	public int getMin() {
		return top.min;
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */