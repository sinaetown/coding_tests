import java.util.*;

class Solution {
    static int[][] damage = {{1,1,1}, {5,1,1}, {25,5,1}};
    static List<int[]> list = new ArrayList<>();
    public int solution(int[] picks, String[] minerals) {
        group(minerals, picks);
        list.sort(new Comparator<int[]>(){
        @Override
        public int compare(int[] arr1, int[] arr2){
            return arr2[2]-arr1[2]; //돌 기준으로 내림차순 정렬
        }
        });
        for(int[] a : list) System.out.println(Arrays.toString(a));
        
        int answer = 0;
        for(int i = 0; i < list.size(); i++){
            if(picks[0] > 0){
                answer += list.get(i)[0];
                picks[0]--;
            }
            else if(picks[1] > 0){
                answer += list.get(i)[1];
                picks[1]--;
            }
            else if(picks[2] > 0){
                answer += list.get(i)[2];
                picks[2]--;
            }
        }       
        return answer;
    }
    
    public void group(String[] minerals, int[] picks){
        for(int i = 0; i < minerals.length; i+=5){
            int dia = 0;
            int iron = 0;
            int stone = 0;
            if(i/5 == picks[0]+picks[1]+picks[2]) break;
            for(int j = i; j < i + 5; j++){
                if(j >= minerals.length) break;
                if(minerals[j].equals("diamond")){
                    dia += damage[0][0];
                    iron += damage[1][0];
                    stone += damage[2][0];
                }
                if(minerals[j].equals("iron")){
                    dia += damage[0][1];
                    iron += damage[1][1];
                    stone += damage[2][1];
                }
                if(minerals[j].equals("stone")){
                    dia += damage[0][2];
                    iron += damage[1][2];
                    stone += damage[2][2];
                }
            }
            
            list.add(new int[]{dia, iron, stone});
        }
    }
}