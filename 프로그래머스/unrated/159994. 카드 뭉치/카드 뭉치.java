class Solution {
    
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int c1Idx = 0;
        int c2Idx = 0;
        for (int gIdx = 0; gIdx < goal.length; gIdx++) {
            String nowGoal = goal[gIdx];
            if (c1Idx < cards1.length && nowGoal.equals(cards1[c1Idx])) {
                c1Idx++;
                continue;
            }
            if (c2Idx < cards2.length && nowGoal.equals(cards2[c2Idx])) {
                c2Idx++;
                continue;
            }
            return "No";
        }
        
        return "Yes";
    }
    
}