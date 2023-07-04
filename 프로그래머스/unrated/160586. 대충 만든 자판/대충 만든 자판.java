import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {

        Map<Character, Integer> keypadMap = new HashMap<>();
        
        for (int keymapIdx = 0; keymapIdx < keymap.length; keymapIdx++) {
            char[] nowKeys = keymap[keymapIdx].toCharArray();
            IntStream.range(0, nowKeys.length)
                .filter(i -> !keypadMap.containsKey(nowKeys[i]) || i < keypadMap.get(nowKeys[i]))
                .forEach(i -> keypadMap.put(nowKeys[i], i + 1));
                
        }
        
        int[] result = new int[targets.length];
        for (int targetIdx = 0; targetIdx < targets.length; targetIdx++) {
            char[] nowTarget = targets[targetIdx].toCharArray();
            int sum = 0;
            for (int nowTargetSeq = 0; nowTargetSeq < nowTarget.length; nowTargetSeq++) {
                if (!keypadMap.containsKey(nowTarget[nowTargetSeq])) {
                    sum = -1;
                    break;
                }
                sum += keypadMap.get(nowTarget[nowTargetSeq]);
            }
            result[targetIdx] = sum;
        }
        
        return result;
    }
}