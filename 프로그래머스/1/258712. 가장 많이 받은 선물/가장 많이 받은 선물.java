import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        //이름1, 이름2
        //  이름1,이름2가 키인 값에 ++
        //  이름1가 키인 값에 ++, 이름2가 키인 값에 --
        
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            idx.put(friends[i], i);
        }
        
        int[] degree = new int[friends.length];
        int[][] weight = new int[friends.length][friends.length];
        for (int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            Integer giver = idx.get(gift[0]);
            Integer taker = idx.get(gift[1]);
            
            weight[giver][taker]++;
            degree[giver]++;
            degree[taker]--;
        }
        
        int answer = 0;
        for (int i = 0; i < idx.size(); i++) {
            int num = 0;
            
            for (int j = 0; j < idx.size(); j++) {
                if (i == j) continue;
                
                if (weight[i][j] > weight[j][i] ||
                        weight[i][j] == weight[j][i] && degree[i] > degree[j]) {
                    num++;
                }
            }
            
            if (answer < num) {
                answer = num;
            }
        }
        
        return answer;
    }
    
}