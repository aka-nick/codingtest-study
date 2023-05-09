import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> cache = new LinkedList<>();
        int time = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            int index = cache.indexOf(city);
            if (0 <= index && index < cacheSize) { // cache hit : 지우고, 새로 넣고, 시간+=1
                cache.remove(index);
                cache.add(0, city);
                time += 1;
            }
            else { // cache miss : 사이즈가 오버된다면 마지막 지우고, 새로 넣고, 시간+=5
                if (cacheSize < cache.size()) cache.removeLast();
                cache.add(0, city);
                time += 5;
            }
        }
        
        return time;
    }
}
