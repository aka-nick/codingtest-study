import java.util.HashMap;
import java.util.Map;

class Solution {
	
    // 양손구락 위치 번호
    private int nowLeftThumb = 10;
    private int nowRightThumb = 12;
    
    // 리턴값 담을 문자열
    private String retVal = "";
	
	public String solution(int[] numbers, String hand) {

        // 번호별 키패드 좌표
        Map<Integer, Integer[]> keypad = new HashMap<Integer, Integer[]>();
        keypad.put(1, new Integer[] {0, 0});
        keypad.put(2, new Integer[] {1, 0});
        keypad.put(3, new Integer[] {2, 0});
        
        keypad.put(4, new Integer[] {0, 1});
        keypad.put(5, new Integer[] {1, 1});
        keypad.put(6, new Integer[] {2, 1});
        
        keypad.put(7, new Integer[] {0, 2});
        keypad.put(8, new Integer[] {1, 2});
        keypad.put(9, new Integer[] {2, 2});
        
        keypad.put(10, new Integer[] {0, 3});
        keypad.put(0 , new Integer[] {1, 3});
        keypad.put(12, new Integer[] {2, 3});
        
        // 탐색
        for (int num : numbers) {
    		if (num == 1 || num == 4 || num == 7) { //왼손 쓸 버튼
        		keyPress("left", num);
        		continue;
        	}
        	else if (num == 3 || num == 6 || num ==9) { //오른손 쓸 버튼
        		keyPress("right", num);
        		continue;
        	}
        	else { //아리까리 버튼: 중간열 버튼 -> 양손 위치와 해당 패드 간의 차이 계산
        		int xDiffLeft = Math.abs(keypad.get(num)[0] - keypad.get(nowLeftThumb)[0]); 
        		int yDiffLeft = Math.abs(keypad.get(num)[1] - keypad.get(nowLeftThumb)[1]); 
        		int xDiffRight = Math.abs(keypad.get(num)[0] - keypad.get(nowRightThumb)[0]);
        		int yDiffRight = Math.abs(keypad.get(num)[1] - keypad.get(nowRightThumb)[1]);
        		
        		// 버튼과 왼손/오른손 간 차이 중에서...
        		if (xDiffLeft + yDiffLeft < xDiffRight + yDiffRight) { // 왼손과의 차이가 더 작은 경우 -> 왼손 쓴다
            		keyPress("left", num);
            		continue;
        		}
        		else if (xDiffLeft + yDiffLeft > xDiffRight + yDiffRight) { // 오른손과의 차이가 더 작은 경우 -> 오른손 쓴다
            		keyPress("right", num);
            		continue;
        		}
        		else { // 같은 경우
        			// 어느손잡이인지에 따라 누른다
        			keyPress(hand, num);
        			continue;
        			
        		}
        	}
        }
        
        return this.retVal;

    }
	
	private void keyPress(String leftOrRight, int pressNum) {
		if ("left".equals(leftOrRight)) {
			this.retVal += "L";
    		this.nowLeftThumb = pressNum;
		}
		else if ("right".equals(leftOrRight)) {
			this.retVal += "R";
    		this.nowRightThumb = pressNum;
		}
	}
    
}