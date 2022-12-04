class Solution {
    public int solution(String s) {

        char[] arr = s.toCharArray();

        int splitCount = 0;
        int lnum = 0;
        int rnum = 0;
        char x = 0;

        for (int i = 0; i < arr.length; i++) {

            if (x == 0) {
                x = arr[i];
            }

            if (x == arr[i]) {
                lnum++;
            }
            else { // x != arr[i]
                rnum++;
            }

            if (lnum == rnum) {
                splitCount++;
                x = 0;
            }
        }

        if (x != 0) {
            splitCount++;
        }

        return splitCount;
    }
}