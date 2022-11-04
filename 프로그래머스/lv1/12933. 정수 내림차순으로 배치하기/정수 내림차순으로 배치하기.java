class Solution {
    public long solution(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        int[] arr = new int[10];
        
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i] - '0']++;
        }
        
        String resultStr = "";
        for (int nowNum = 9; 0 <= nowNum; nowNum--) {
            int nowCount = arr[nowNum];
            if (0 < nowCount) {
                for (int j = 0; j < nowCount; j++) {
                    resultStr += nowNum;
                }
            }
        }
        
        return Long.valueOf(resultStr);
    }
}