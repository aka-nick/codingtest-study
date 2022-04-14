import java.util.*;

public class Solution {
    public Integer[] solution(int []arr) {
        
        if (arr.length == 0) return null;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < arr.length; i += 1) {
            
            if (i == 0) {
                list.add(arr[i]);
                continue;
            }
            
            if (arr[i-1] != arr[i]) list.add(arr[i]);
        
        }
        
        return list.toArray(new Integer[0]);
    }
}