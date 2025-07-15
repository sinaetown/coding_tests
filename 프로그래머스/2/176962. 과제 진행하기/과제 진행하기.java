import java.util.*;

class Subject{
    int start;
    String subject;
    int playtime;
    
    public Subject(String subject, int start, int playtime){
        this.subject = subject;
        this.start = start;
        this.playtime = playtime;
    }
}

class Solution {
    List<Subject> list = new ArrayList<>();
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int index = 0;
        for(int i = 0; i < plans.length; i++){
            list.add(new Subject(plans[i][0], toMin(plans[i][1]), Integer.parseInt(plans[i][2])));
        }
        
        list.sort(new Comparator<Subject>(){
            @Override
            public int compare(Subject s1, Subject s2){
                return s1.start - s2.start;
            }
        });
        
        int workIndex= 0;
        Subject nowWork = list.get(workIndex);
        Stack<Subject> stack = new Stack<>();
        int currentTime = 0;
        while(true){
            if(workIndex == plans.length-1){ //마지막 과목일 경우
                answer[index++] = nowWork.subject; // 그 과목 넣고
                while(!stack.isEmpty()){
                    answer[index++] = stack.pop().subject; //진행중이던 과목들 다 넣은 후
                }
                break;
            }
            else{ //마지막 과목이 아닐 경우
                Subject nextWork = list.get(workIndex+1);
                if(nowWork.start + nowWork.playtime <= nextWork.start){ //끝내기 가능
                    answer[index++] = nowWork.subject; // 그 과목 넣기
                    currentTime = nowWork.start + nowWork.playtime;
                    while(!stack.isEmpty()){
                        Subject popped = stack.pop();
                        int remainingTime = nextWork.start - currentTime;
                        if(remainingTime >= popped.playtime){ //진행 중인 과목 끝내기
                            answer[index++] = popped.subject;
                            currentTime = currentTime + popped.playtime;
                        }
                        else{ //끝낼 수 없을 때
                            stack.push(new Subject(popped.subject, popped.start, popped.playtime - remainingTime));
                            currentTime = nextWork.start;
                            break;
                        }
                    }
                    nowWork = nextWork;
                    workIndex++;
                }                    
                else{ //끝낼 수 없을 경우 멈추기
                    stack.add(new Subject(nowWork.subject, nowWork.start, nowWork.playtime - (nextWork.start - nowWork.start))); //진행 중인 스택에 넣기
                    nowWork = nextWork;
                    workIndex++;
                }
                
            }
        }
        return answer;
    }
    
    
    public int toMin(String start){
        String[] split = start.split(":");
        int hr = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        return hr*60+min;
    }
}