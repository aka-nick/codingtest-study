import java.util.HashSet;
import java.util.Arrays;
import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        
        for (int i = 0; i < numbers.length - 1; i += 1)
            for (int j = i + 1; j < numbers.length; j += 1)
                set.add(numbers[i] + numbers[j]);
        
        return Arrays.stream(set.toArray(new Integer[set.size()])).mapToInt(Integer::intValue).toArray();
    }
}