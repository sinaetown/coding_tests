class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        
        int count = 0;
        for(boolean b : finished){
            if(!b){
                count++;
            }
        }
        
        String[] answer = new String[count];
        int index = 0;
        for(int i = 0; i < finished.length; i++){
            if(finished[i]==false){
                answer[index++] = todo_list[i];
            }
        }
        
        return answer;
    }
}