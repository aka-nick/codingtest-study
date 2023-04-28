import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int solution(String t, String p) {
        
        Long count = IntStream.rangeClosed(0, t.length() - p.length())
            .mapToLong(l -> Long.parseLong(t.substring(l, l + p.length())))
            .filter(subnum -> subnum <= Long.parseLong(p))
            .count();
        
        return count.intValue();
    }
}