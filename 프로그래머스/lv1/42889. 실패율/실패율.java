import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] stages) {
		HashMap<Integer, Integer> stagesMap = new HashMap<Integer, Integer>(); // 라운드별 진행유저 수 
		for (int roundUserCount : stages) {
			int putValue = (stagesMap.get(roundUserCount) == null) ? 1 : (stagesMap.get(roundUserCount) + 1);
			stagesMap.put(roundUserCount, putValue);
		}
		
		HashMap<Integer, Float> resultMap = new HashMap<Integer, Float>(); // 라운드별 실패율 
		int preRoundUsers = 0;
		int totalUsers = stages.length;
		float failRate = 0F;
		for (int i = 1; i <= N; i += 1) {
			totalUsers -= preRoundUsers;
			if (totalUsers == 0) {
				resultMap.put(i, 0F);
			}
			else {				
				int nowUser = stagesMap.get(i) == null ? 0 : stagesMap.get(i);
				failRate = (float)nowUser / totalUsers;
				resultMap.put(i, failRate);
				
				preRoundUsers = nowUser;
			}
		}
		
		// 맵에 저장된 라운드별 실패율을 정렬하여 List에 엔트리로 담음.
//		List<Map.Entry<Integer, Float>> entries = resultMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
		List<Map.Entry<Integer, Float>> entries = new ArrayList(resultMap.entrySet());
		entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		
		int[] answer = new int[entries.size()];
		int i = 0;
		for (Map.Entry<Integer, Float> e : entries) {
			answer[i] = e.getKey();
			i += 1;
		}
		
        return answer;
    }
}