import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        if (arr.length <= 1) return new int[]{-1};
        
        int smallest = getSmallestNumber(arr);
        
        return getArrayWithoutSmallest(arr, smallest);
    }
    
    private int getSmallestNumber(int[] arr) {
        
        int result = Integer.MAX_VALUE;

        for (int a : arr) {
            result = Math.min(result, a);
        }

        return result;
    }
    
    private int[] getArrayWithoutSmallest(int[] arr, int smallest) {
        
        int[] newArr = new int[arr.length - 1];
        
        int orgArrIdx = 0;
        for (int idx = 0; idx < arr.length - 1; idx++) {
            
            if (arr[idx] == smallest) orgArrIdx++;
            
            newArr[idx] = arr[orgArrIdx++];
        }
        
        return newArr;
    }
}