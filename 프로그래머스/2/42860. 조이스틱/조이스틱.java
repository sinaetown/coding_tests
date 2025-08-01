class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int minMove = length-1;
        
        for(int i = 0; i < length; i++){
            char target = name.charAt(i);
            int cnt = Math.min(target-'A', 'Z'-target+1); //알파벳 바꾸는 횟수
            answer += cnt;
            //연속적인 A가 끝나는 지점 찾기
            int trackA = i+1;
            while(trackA < length && name.charAt(trackA) == 'A'){
                trackA++;
            }
            //문자열 처음부터 탐색
            minMove = Math.min(minMove, i + i + length - trackA);
            //문자열 마지막부터 탐색
            minMove = Math.min(minMove, (length - trackA) * 2 + i);
        }
        answer += minMove;
        
        return answer;
    }
}