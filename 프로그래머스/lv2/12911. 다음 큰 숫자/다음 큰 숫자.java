class Solution {

    public int solution(int n) {

        int numberOfOne = getNumberOfOne(n);
        for (int i = n + 1; i <= 1000000; i++) {
            if (numberOfOne == getNumberOfOne(i)) {
                return i;
            }
        }

        return n;
    }

    private int getNumberOfOne(int n) {
        int count = 0;
        for (char c : Integer.toString(n, 2).toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

}