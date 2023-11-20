class Solution {
    public int solution(int hp) {
        int answer = 0;
        // int jangkun = 5;
        // int byungjung = 3;
        // int ill = 1;
        
        int jangkun = 0;
        int byungjung = 0;
        int ill = 0;
        
        while(hp > 0){
            if((hp)>=5){
                jangkun=(int)(hp/5);
                hp-=5*jangkun;
            }
            else if((hp)>=3){
                byungjung=(int)(hp/3);
                hp-=3*byungjung;
            }
            else{
                ill=(int)(hp/1);
                hp-=1*ill;
            }
        }
        answer=jangkun+byungjung+ill;
        return answer;
    }
}