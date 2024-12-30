class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] range = new int[200];
        for (int[] line : lines) {
            for (int i = line[0] + 100; i < line[1] + 100; i++) {
                range[i]++;
            }
        }
        for(int r : range){
            if(r>1) answer++;
        }
        return answer;
    }
}