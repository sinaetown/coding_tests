import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        List<Integer> l = new ArrayList<Integer>();
        int count = 0;
        for(int i = 1; i < rank.length+1; i++){ //ranking
            for(int j = 0; j < rank.length; j++){ //student number (index)
                if(rank[j]==i && attendance[j]){
                    count++;
                    if(count==1){
                        answer += 10000*j;
                    }
                    else if(count==2){
                        answer += 100*j;
                    }
                    else if(count==3){
                        answer += j;
                    }
                }
        }
        }
        
        return answer;
    }
}