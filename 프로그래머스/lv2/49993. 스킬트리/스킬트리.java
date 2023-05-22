import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int result = skill_trees.length;
        
        checkSkillTrees:
        for (int i = 0; i < skill_trees.length; i++) {
            Deque<Character> q = new ArrayDeque<>();
            Map<Character, Integer> map = new HashMap<>();
            char[] sArr = skill.toCharArray();
            for (char s : sArr) {
                q.addLast(s);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            
            char[] skillTree = skill_trees[i].toCharArray();
            for (int j = 0; j < skillTree.length; j++) {
                char nowSkill = skillTree[j];
                
                if (map.containsKey(nowSkill)) {
                    int countOfNowSkill = map.get(nowSkill);
                    map.put(nowSkill, countOfNowSkill - 1);
                    
                    if (nowSkill != q.pollFirst()) {
                        result--;
                        continue checkSkillTrees;
                    }
                }
                
            }
        }
        
        return result;
    }
}