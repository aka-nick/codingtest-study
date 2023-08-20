import java.util.*;
import java.util.stream.*;

/*

1~n번으로 분류되는 개인정보
약관의 종류는 여러개, 약관마다 보관기간이 있음
- 가지고 있는 개인정보들의 약관 종류를 알고있음.
- 유효기간이 지난(파기해야 하는) 개인정보의 번호들을 배열로 return

* 모든 달은 28일까지 있다고 친다.

*/
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] tArr = terms[i].split(" ");
            termsMap.put(tArr[0], Integer.parseInt(tArr[1]));
        }
        
        return IntStream.range(0, privacies.length)
            .filter(idx -> {
                String privacy = privacies[idx];
                String[] pArr = privacy.split(" ");
                String term = pArr[1];
                Integer period = termsMap.get(term);
                String startDate = pArr[0];
                String endDate = addMonth(startDate, period);
                return 0 < compareDate(today, endDate);
            })
            .map(idx -> idx + 1)
            .toArray();
    }
    
    private int compareDate(String date1, String date2) {
        String[] dates1 = date1.split("[.]");
        String[] dates2 = date2.split("[.]");
        for (int i = 0; i < 3; i++) {
            int d1 = Integer.parseInt(dates1[i]);
            int d2 = Integer.parseInt(dates2[i]);
            if (d1 != d2) {
                return d1 - d2;
            }
        }
        return 0;
    }
    
    private String addMonth(String date, int addMonth) {
        String[] dates = date.split("[.]");
        if (dates[2].equals("01")) {
            dates[2] = "28";
            addMonth--;
        }
        else {
            int newDay = Integer.parseInt(dates[2]) - 1;
            if (newDay < 10) {
                dates[2] = "0" + newDay;
            }
            else {
                dates[2] = "" + newDay;
            }
        }
        int addedMonth = Integer.parseInt(dates[1]) + addMonth;
        if (addedMonth <= 12) {
            String strAddedMonth = addedMonth < 10 ? "0" + addedMonth : "" + addedMonth;
            return dates[0] + "." + strAddedMonth + "." + dates[2];
        }
        int addYear = (addedMonth - 1) / 12;
        addedMonth %= 12;
        if (addedMonth == 0) addedMonth = 12;
        String strAddedMonth = addedMonth < 10 ? "0" + addedMonth : "" + addedMonth;
        return "" + (Integer.parseInt(dates[0]) + addYear) + "." + strAddedMonth + "." + dates[2];
    }
}