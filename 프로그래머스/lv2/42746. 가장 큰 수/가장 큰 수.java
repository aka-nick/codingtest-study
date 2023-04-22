import java.util.*;

class Solution {

    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(((o1, o2) -> {
                    int num1 = Integer.parseInt("" + o1 + o2);
                    int num2 = Integer.parseInt("" + o2 + o1);
                    return num2 - num1;
                }))
                .forEach(sb::append);

        String result = sb.toString();
        return result.replace("0", "").equals("") ? "0" : result;
    }
    
}