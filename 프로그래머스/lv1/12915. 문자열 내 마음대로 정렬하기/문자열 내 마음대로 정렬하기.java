import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        TreeSet<String>[] tsa = new TreeSet[26];
        
        for (String s : strings) {
        	if (null == tsa[s.charAt(n) - 97]) 
        		tsa[s.charAt(n) - 97] = new TreeSet<String>();
        	
        	tsa[s.charAt(n) - 97].add(s);
        }
        
        int idx = 0;
        for (TreeSet<String> ts : tsa) {
        	if (null == ts) continue;
        	
        	Iterator<String> is =  ts.iterator();
        	while(is.hasNext()) {
        		strings[idx] = is.next();
        		idx += 1;
        	}
        }
        
        return strings;
    }
}