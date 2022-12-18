class Solution {

    public int solution(int n) {

        int count = 0;
        int sum = 1;
        int left = 1;
        int right = 1;

        while (left + right <= n) {
            if (sum < n) {
                sum += ++right;
            }
            else {
                sum -= left++;
            }

            if (sum == n) {
                count++;
            }
        }

        count++;
        return count;
    }

}