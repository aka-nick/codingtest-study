import java.util.*;
import java.util.stream.*;

class Solution {
    
    static final int SALE_DAYS = 10;
    
    Map<String, Integer> saleAndQuantity = new HashMap<>();
    String[] discount;
    int needQuantity;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        this.discount = discount;
        needQuantity = Arrays.stream(number)
            .reduce(0, (a, b) -> a + b);
        
        for (int dayIdx = 0; dayIdx < discount.length; dayIdx++) {
            String sale = discount[dayIdx];
            
            addSale(sale);
            
            boolean isMatched = true;
            for (int wIdx = 0; wIdx < want.length; wIdx++) {
                if (saleAndQuantity.getOrDefault(want[wIdx], 0) != number[wIdx]) {
                    isMatched = false;
                    break;
                }
            }
            
            if (isMatched) {
                answer++;
            }
            
            if (SALE_DAYS == saleAndQuantity.entrySet().stream()
                .map(entry -> entry.getValue())
                .reduce(0, (a, b) -> a + b)) {
                removeSale(dayIdx);
            }
        }

        return answer;
    }
    
    void addSale(String sale) {
        saleAndQuantity.put(sale, saleAndQuantity.getOrDefault(sale, 0) + 1);
    }
    void removeSale(int dayOfZeroBased) {
        int day = dayOfZeroBased + 1;
        String saleForRemove = discount[day - SALE_DAYS];
        saleAndQuantity.put(saleForRemove, saleAndQuantity.get(saleForRemove) - 1);
    }
}