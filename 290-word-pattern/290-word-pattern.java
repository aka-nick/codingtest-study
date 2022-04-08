import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {

		HashMap<Character, String> map1 = new HashMap<Character, String>();
		HashMap<String, Character> map2 = new HashMap<String, Character>();
		char[] pa = pattern.toCharArray();
		String[] sa = s.split(" ");
		
		if (pa.length != sa.length) return false;
		
		for (int i = 0; i < pattern.length(); i += 1) {
			
			if (map1.containsKey(pa[i]) && !map1.get(pa[i]).equals(sa[i])) 			
				return false;
			else if (map2.containsKey(sa[i]) && map2.get(sa[i]) != pa[i])
				return false;
			else {
				map1.put(pa[i], sa[i]);
				map2.put(sa[i], pa[i]);
			}

		}
		
		return true;
	}
}