class Solution {

    public String solution(String s) {

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char nowChar = chars[i];

            if (isFirstChar(chars, i) && Character.isLowerCase(nowChar)) {
                chars[i] = Character.toUpperCase(nowChar);
            }
            else if (!isFirstChar(chars, i) && Character.isUpperCase(nowChar)) {
                chars[i] = Character.toLowerCase(nowChar);
            }
        }

        return String.valueOf(chars);
    }

    private boolean isFirstChar(char[] chars, int i) {
        return (i == 0 || chars[i - 1] == ' ') && chars[i] != ' ';
    }
}