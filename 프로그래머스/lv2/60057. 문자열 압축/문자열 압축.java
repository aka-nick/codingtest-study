class Solution {
    public int solution(String s) {
        int resultLength = s.length();

        int pos; // (기준/비교)문자열의 시작 위치
        for (int i = 1; i <= s.length() / 2; i++) { // 기준문자열의 길이를 늘려나가기 위한 loop
            pos = 0;
            int compressLength = s.length();

            while (pos + i <= s.length()) { // 기준문자열을 이동하기 위한 loop
                String baseString = s.substring(pos, pos + i);

                int appear = 1; // 등장 횟수 (중복횟수 X)
                while (pos + i <= s.length()) { // 비교문자열을 이동하기 위한 loop
                    pos += i;
                    String compareString = pos + i <= s.length()
                            ? s.substring(pos, pos + i)
                            : null;

                    if (baseString.equals(compareString)) {
                        appear++;
                    } else {
                        if (1 < appear) {
                            compressLength -= i * appear;
                            compressLength += String.valueOf(appear).length();
                            compressLength += baseString.length();
                        }
                        break;
                    }
                }

            }
            resultLength = Math.min(resultLength, compressLength);

        }

        return resultLength;
    }
}