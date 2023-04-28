import java.util.*;
import java.util.stream.*;

class Solution {

    public int solution(int[] people, int limit) {
        
        // 해 : 가장 큰 사람과 가장 작은 사람 위주로 태우기를 시도한다.
        Arrays.sort(people);
        
        int idxOfLight = 0;
        int idxOfHeavy = people.length - 1;
        int countOfBoat = 0;
        
        while (idxOfLight <= idxOfHeavy) {
            if (idxOfLight == idxOfHeavy) {
                idxOfLight++;
                countOfBoat++;
                continue;
            }
            
            if (people[idxOfLight] + people[idxOfHeavy] <= limit) {
                idxOfLight++;
                idxOfHeavy--;
                countOfBoat++;
            }
            else {
                idxOfHeavy--;
                countOfBoat++;
            }
        }
        
        return countOfBoat;
    }
    
}