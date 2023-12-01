import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> nameRank = new HashMap<>();
        Map<Integer, String> rankName = new HashMap<>();
        IntStream.range(0, players.length) 
            .forEach(i -> {
                nameRank.put(players[i], i + 1);
                rankName.put(i + 1, players[i]);
            });
        
        for (String backName : callings) {
            Integer backRank = nameRank.get(backName);
            Integer frontRank = backRank - 1;
            String frontName = rankName.get(frontRank);
            
            nameRank.put(backName, backRank - 1);
            rankName.put(frontRank, backName);
            
            nameRank.put(frontName, backRank);
            rankName.put(backRank, frontName);
        }
        
        return nameRank.entrySet().stream()
            .sorted(Comparator.comparingInt(entry -> entry.getValue()))
            .map(entry -> entry.getKey())
            .toArray(String[]::new);
    }
}