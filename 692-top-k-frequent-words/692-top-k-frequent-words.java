class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
		
		ArrayList<String> keyList = new ArrayList<String>();
		for (String key : map.keySet()) keyList.add(key);
		
		keyList.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return map.get(o2) - map.get(o1) == 0 
						? o1.compareTo(o2) : map.get(o2) - map.get(o1);
			}
		});
		
		return keyList.subList(0, k);
        
    }
}