class Solution {
    
    public int[] solution(int[] arr, int[][] queries) {
        for (int qIdx = 0; qIdx < queries.length; qIdx++) {
            int s = queries[qIdx][0];
            int e = queries[qIdx][1];
            int k = queries[qIdx][2];
            
            for (int i = 0; i < arr.length; i++) {
                if (i < s) continue;
                if (e < i) continue;
                if (!(i == 0 || i % k == 0)) continue;
                arr[i]++;
            }
        }
        
        return arr;
    }
    
}