class Solution {
    public String solution(String s) {
        char[] ca = s.toLowerCase().toCharArray();
        int i = 0;
        while (i < ca.length) {
            if (97 <= ca[i] && ca[i] <= 122) {
                ca[i] = (char)(ca[i] - 32);
                i += 2;
                continue;
            }

            i++;
            continue;
        }

        return new String(ca);
    }
}