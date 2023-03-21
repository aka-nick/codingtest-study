import java.util.*;

class Solution {

    // n : 플레이어 수
    // words : 나열되는 단어
    // 탈락하는 선수의 번호와 탈락 턴 수를 숫자로 나타내야 한다: 1번 선수가 2번째 턴에 탈락하면 : {1, 2} 리턴
    // 탈락 조건 : 안 이어지는 단어 말하기 / 앞에서 말한 단어 말하기
    // 예외 조건 : 탈락자가 없으면 {0, 0}을 리턴
    public int[] solution(int n, String[] words) {
        // 모수가 엄청 크지 않아서 대충 풀어도 될 것 같지만 Hash 자료구조를 써보자
        Set<String> used = new HashSet<>();
        
        int player = 1;
        int round = 1;
        char beforeChar = words[0].charAt(0);
        
        for(String word : words) {
            if (n < player) { // '3. 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.'
                player = 1;
                round++;
            }
            
            // 탈락 체크
            //  앞에서 말한 단어 말하기?
            if (used.contains(word)) {
                return new int[]{player, round};
            }
            
            //  안 이어지는 단어 말하기?
            if (beforeChar != word.charAt(0)) {
                return new int[]{player, round};
            }
            
            beforeChar = word.charAt(word.length() - 1); // 마지막 단어의 마지막 글자 기억
            used.add(word); // 나왔던 단어 기록
            
            player++; // 다음 선수 차례로
        }
        
        return new int[]{0, 0};
    }
    
}