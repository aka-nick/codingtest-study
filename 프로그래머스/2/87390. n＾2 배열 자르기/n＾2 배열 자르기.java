import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();
        for(long i=left;i<=right;i++){
            int row = (int)(1 + i/n);
            int col = (int)(1 + i%n);
            if(row <= col){
                list.add(col);
            }else{
                list.add(row);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<result.length;i++){
            result[i] = list.get(i);
        }
        return result;
    }
}