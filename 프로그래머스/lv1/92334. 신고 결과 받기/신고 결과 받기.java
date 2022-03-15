import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answers = new int[id_list.length]; // 답장나갈 숫자 배열 - ID순 
        Set<String> reports = new HashSet<String>(); // 중복을 제거한 신고 내용
        for (String r : report) reports.add(r);
        Map<String, Integer> report_counts = new HashMap<String, Integer>(); // ID별 신고당한 숫자 
        for (String id : id_list) report_counts.put(id, 0);
        
        // 신고당한 횟수를 카운팅 
        for (String r : reports) {
        	String[] tmp = r.split(" ");
        	report_counts.put(tmp[1], report_counts.get(tmp[1]) + 1);
        }
        
        // 카운팅 된 신고당한 횟수를 k와 비교하여 클 경우, 리턴 배열의 [신고자번째]에 += 1 
        for (String r : reports) {
        	String[] tmp = r.split(" ");
        	if (report_counts.get(tmp[1]) >= k)
        		answers[Arrays.asList(id_list).indexOf(tmp[0])] += 1;
        }
        
        return answers;
    }
}