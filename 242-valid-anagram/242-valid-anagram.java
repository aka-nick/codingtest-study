import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		if (s.length() != t.length()) return false;
		
		for (char c : s.toCharArray()) map.put(c, (map.getOrDefault(c, 0) + 1));
		
		for (char c : t.toCharArray()) {
			if (!map.containsKey(c)) return false;
			
			int tc = map.get(c);
			if (tc == 0) return false;
			
			map.put(c, tc - 1);
		}
		
		for (char key : map.keySet()) if (map.get(key) != 0) return false;
		
		return true;
		
	}
}