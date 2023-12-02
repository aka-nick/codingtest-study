import java.util.*;
import java.util.stream.*;

class Solution {

    public int solution(int[] bandage, int health, int[][] attacks) {
        int hDelay = bandage[0];
        int hPerSec = bandage[1];
        int hAmount = bandage[2];
        
        int nowHealth = health;
        int nowHDelay = hDelay;
        int time = 0;
        for (int[] attack : attacks) {
            int aTime = attack[0];
            int aDamage = attack[1];
            
            // 매 턴의 로직
            while (time < aTime) {
                // 매턴마다 시간은 흘러감
                time++;
                
                // 매턴마다 딜레이 감소
                nowHDelay--;
                
                
                // 공격 시간이 되면 공격 후(데미지 입힘, hDelay 초기화) 다음 턴 진행
                if (aTime == time) { 
                    nowHealth -= aDamage;
                    nowHDelay = hDelay;
                }
                // 공격 당하지 않은 타임에는 기본 회복
                else {
                    nowHealth = (health < nowHealth + hPerSec) ? health : nowHealth + hPerSec;
                }
                
                // 힐 딜레이 다 차면 힐 회복도(힐량만큼 체력 증가, hDelay 초기화)
                if (nowHDelay == 0) {
                    nowHealth = (health < nowHealth + hAmount) ? health : nowHealth + hAmount;
                    nowHDelay = hDelay;
                }
                
                // 살아있는지 확인(죽었으면 다음 타임 진행 안함)
                if (nowHealth <= 0) {
                    break;
                }
                
            }
            
            // 살아있는지 확인(죽었으면 다음 턴 진행 안함)
            if (nowHealth <= 0) {
                break;
            }
        }    

        return nowHealth <= 0 ? -1 : nowHealth;
    }
    
}
