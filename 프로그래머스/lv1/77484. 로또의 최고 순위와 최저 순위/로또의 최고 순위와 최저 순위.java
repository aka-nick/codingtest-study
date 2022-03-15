class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int match_cnt = 0;
        int zero_cnt = 0;
        
        for(int num : lottos) {
            for(int win_num : win_nums) {
                if (num == 0) {
                    zero_cnt += 1;
                    break;
                }
                if (win_num == num) {
                    match_cnt += 1;
                    break;
                }
            }
        }
        
        int max_rank = 7 - (zero_cnt + match_cnt);
        max_rank = max_rank > 6 ? 6 : max_rank;
        
        int min_rank = 7 - match_cnt;
        min_rank = min_rank > 6 ? 6 : min_rank;
        
        int[] answer = {max_rank, min_rank};
        
        return answer;
    }
}