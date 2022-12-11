import java.util.*; 

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> countChar = new HashMap<>();
        int[] result = new int[s.length()];

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!countChar.containsKey(chars[i])) {
                result[i] = -1;
            }
            else {
                result[i] = i - countChar.get(chars[i]);
            }
            countChar.put(chars[i], i);
        }

        return result;
    }
}