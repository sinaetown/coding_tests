import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int recoveryTime = bandage[0];
        int recovery = bandage[1];
        int additional = bandage[2];
        int time = 0;
        int success = 0;
        int maxHealth = health;
        Queue<int[]> queue = new ArrayDeque<>();
         for(int i = 0; i < attacks.length; i++){
            int[] attack = attacks[i];
            int attackTime = attack[0];
            int attackDamage = attack[1];
            queue.add(new int[]{attackTime, attackDamage});
         }
        int a = 0;
        int b = 0;
        boolean flag = false;
        while(time<=attacks[attacks.length-1][0]){
            time++;
            if(!flag) {
                if(queue.isEmpty()) break;
                int[] polled = queue.poll();
                a = polled[0];
                b = polled[1];
                flag = true;
            }
            if(time!=a){ // 공격받지 않고 있을 때
                if(health+recovery >= maxHealth) health=maxHealth; // 최대 체력일 때
                else health+=recovery; // 체력이 떨어졌을 때
                success++; //연속 성공
                if(success == recoveryTime){
                    if(health+additional >= maxHealth) health=maxHealth;
                    else health+=additional;
                    success = 0; //초기화
                }
            }
            else{ //공격받고 있을 때
                success = 0; //초기화
                health-=b;
                flag = false;
                if(health<=0) return -1;
            }
        }
            
        return health;
    }
}