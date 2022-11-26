import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {

            int[] result = new int[score.length];
            List<Integer> list = new ArrayList<>();
            
            for (int i = 0; i < score.length; i++) {

                if (list.size() < k) {
                    list.add(score[i]);
                }
                else {
                    if (list.get(0) < score[i]) {
                        list.remove(0);
                        list.add(0, score[i]);
                    }
                }
                list.sort(Comparator.comparingInt(o -> o));

                result[i] = list.get(0);
            }

            return result;
        }
}