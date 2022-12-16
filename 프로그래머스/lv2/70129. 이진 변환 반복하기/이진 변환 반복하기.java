class Solution {
    public int[] solution(String s) {

        int numberOfZero = 0;
        int numberOfConversion = 0;

        while (!"1".equals(s)) {
            numberOfConversion++;
            numberOfZero += countZero(s);

            s = getNewBinaryString(s);
        }

        return new int[]{numberOfConversion, numberOfZero};
    }

    private int countZero(String s) {
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') result++;
        }
        return result;
    }

    private String getNewBinaryString(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '1') result.append(c);
        }
        return Integer.toString(result.length(), 2);
    }

}