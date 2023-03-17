class Solution {

    StringBuilder sb = new StringBuilder();
    Integer number = 0;

    /**
    진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
     */
    public String solution(int n, int t, int m, int p) {

        while (sb.length() < t * m) {
            sb.append(Integer.toString(number++, n));
        }

        StringBuilder result = new StringBuilder();
        int idx = p - 1;
        while (t-- > 0) {
            result.append(sb.charAt(idx));
            idx += m;
        }

        return result.toString().toUpperCase();
    }
}