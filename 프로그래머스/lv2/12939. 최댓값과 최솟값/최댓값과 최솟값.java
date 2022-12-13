import java.util.*;

class Solution {
    public String solution(String s) {

        int min = Arrays.stream(s.split(" "))
                .mapToInt(i -> Integer.parseInt(i))
                .min()
                .getAsInt();
        int max = Arrays.stream(s.split(" "))
                .mapToInt(i -> Integer.parseInt(i))
                .max()
                .getAsInt();

        return new StringBuilder().append(min).append(" ").append(max).toString();
    }
}