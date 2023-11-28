import java.util.stream.*;
import java.util.*;

class Solution {
    
    public int[][] solution(
        int[][] data, // code, date, maximum, remain
        String ext, 
        int val_ext, 
        String sort_by) 
    {
        int extIdx = getIdx(ext);
        int sortIdx = getIdx(sort_by);
        
        return Arrays.stream(data)
            .filter(d -> d[extIdx] < val_ext)
            .sorted(Comparator.comparingInt(d -> d[sortIdx]))
            .toArray(int[][]::new);
    }
    
    private int getIdx(String standard) {
        return switch (standard) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> 0;
        };
    }
    
}