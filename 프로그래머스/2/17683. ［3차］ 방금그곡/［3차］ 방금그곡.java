import java.util.*;
class Solution {
    public static class Music{
        String title;
        int played;
        int index;
        
        public Music(String title, int played, int index){
            this.title = title;
            this.played = played;
            this.index = index;
        }
    }
    
    public static List<Music> list = new ArrayList<>();
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = change(m);
        int ind = 0;
        for(String music : musicinfos){
            ind++;
            String[] split = music.split(",");
            int start = toMin(split[0]);
            int end = toMin(split[1]);
            String title = split[2];
            String notes = change(split[3]);
            String playedNotes = play(notes, start, end);
            if(playedNotes.contains(m)){
                list.add(new Music(title, end-start, ind));
            }
        }
        if(list.size()==0) return "(None)";
        if(list.size()==1) return list.get(0).title;
        else{
            list.sort(new Comparator<Music>(){
            @Override
            public int compare(Music m1, Music m2){
                if(m1.played == m2.played) return m1.index - m2.index;
                return m2.played - m1.played; //내림차순  
            }
        });
            answer = list.get(0).title;
        }
         return answer;
    }
    
    public String play(String notes, int start, int end){
        StringBuilder sb = new StringBuilder();
        int len = notes.length();
        int playTime = end - start;
        for(int i = 0; i < playTime; i++){
            sb.append(notes.charAt(i%len));
        }
        return sb.toString();
    }
    
    public String change(String notes){
        notes = notes.replace("C#", "c");
        notes =notes.replace("D#", "d");
        notes =notes.replace("F#", "f");
        notes = notes.replace("G#", "g");
        notes = notes.replace("A#", "a");
        notes = notes.replace("B#", "b");
        return notes;
    }
    
    public int toMin(String time){
        String[] splitted = time.split(":");
        int hr = Integer.parseInt(splitted[0]);
        int min = Integer.parseInt(splitted[1]);
        return hr*60+min;
    }
}