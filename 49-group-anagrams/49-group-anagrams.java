class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
		
		Map<String, List<String>> aListMap = new HashMap<String, List<String>>();
		for (String str : strs) {
			
			Map<Character, Integer> charMap = new TreeMap<Character, Integer>(); 
			for (int i = 0; i < str.length(); i += 1) {
				int charCount = charMap.getOrDefault(str.charAt(i), 0);
				charMap.put(str.charAt(i), charCount + 1);
			}
			
			StringBuilder sb = new StringBuilder();
			for (char key : charMap.keySet()) 
				sb.append(key).append(charMap.get(key));
			
			List<String> aList;
			if (!aListMap.containsKey(sb.toString())) {
				aList = new ArrayList<String>();
				aList.add(str);
				aListMap.put(sb.toString(), aList);
			}
			else {
				aList = aListMap.get(sb.toString());
				aList.add(str);
			}
		}
		
		return new ArrayList<List<String>>(aListMap.values());
	}
}