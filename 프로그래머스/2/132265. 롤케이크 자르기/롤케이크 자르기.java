import java.util.*;

class Solution {
    public int solution(int[] topping) {
        // 왼쪽부터 커팅해봄:
        //      현재 위치에서 자르면 왼쪽에 몇개의 토핑이 올라가는지, 
        //      왼쪽토핑개수 배열(leftToppingCounts)에 저장
        Set<Integer> leftSet = new HashSet<>();
        int[] leftToppingCounts = new int[topping.length];
        for (int i = 0; i < topping.length; i++) {
            if (!leftSet.contains(topping[i])) {
                leftSet.add(topping[i]);
            }
            leftToppingCounts[i] = leftSet.size();
        }
        
        // 오른쪽부터 커팅해봄:
        //      현재 위치에서 자르면 오른쪽에 몇개의 토핑이 올라가는지,
        //      오른쪽토핑개수 배열(rightToppingCounts)에 저장
        Set<Integer> rightSet = new HashSet<>();
        int[] rightToppingCounts = new int[topping.length];
        for (int i = topping.length - 1; 0 <= i; i--) {
            if (!rightSet.contains(topping[i])) {
                rightSet.add(topping[i]);
            }
            rightToppingCounts[i] = rightSet.size();
        }

        // 각 자른 위치를 체크해서, 양쪽의 토핑 개수가 같으면 카운팅
        int answer = 0;
        for (int i = 0; i < topping.length - 2; i++) {
            if (leftToppingCounts[i] == rightToppingCounts[i + 1]) answer++;
        }
        
        return answer;
    }
}