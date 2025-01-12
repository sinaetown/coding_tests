import java.util.*;

class Solution {
     public class Song {
        int plays;
        int index;

        public Song(int plays, int index) {
            this.plays = plays;
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public int getPlays() {
            return plays;
        }
    }

    public class Compare implements Comparator<Song> {
        public int compare(Song s1, Song s2) {
            if (s2.plays == s1.plays) return s1.index - s2.index;
            return s2.plays - s1.plays;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Song>> map = new HashMap<>();
        Map<String, Integer> countsByGenre = new HashMap<>();
        List<Integer> sub = new ArrayList<>();
        Map<String, Integer> orderedGenre = new LinkedHashMap<>();
        for (int g = 0; g < genres.length; g++) {
            if (!map.containsKey(genres[g])) {
                countsByGenre.put(genres[g], plays[g]);
                List<Song> songs = new ArrayList<>();
                songs.add(new Song(plays[g], g));
                map.put(genres[g], songs);
            } else {
                countsByGenre.put(genres[g], countsByGenre.get(genres[g]) + plays[g]);
                map.get(genres[g]).add(new Song(plays[g], g));
            }
        }
        for (Map.Entry<String, Integer> entry : countsByGenre.entrySet()) {
            sub.add(entry.getValue());
        }
        sub.sort(Comparator.reverseOrder());
        for (int s = 0; s < sub.size(); s++) {
            for (Map.Entry<String, Integer> entry : countsByGenre.entrySet()) {
                if (Objects.equals(entry.getValue(), sub.get(s))) {
                    orderedGenre.put(entry.getKey(), entry.getValue());
                }
            }
        }
        for (List<Song> l : map.values()) {
            l.sort(new Compare());
        }
        List<Integer> list = new ArrayList<>();
        Iterator<String> it = orderedGenre.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            for (Map.Entry<String, List<Song>> entry : map.entrySet()) {
                if (entry.getKey().equals(next)) {
                    List<Song> songs = entry.getValue();
                    if (songs.size() == 1) list.add(songs.get(0).index);
                    else {
                        for (int j = 0; j < 2; j++) {
                            list.add(songs.get(j).index);
                        }
                    }

                }
            }
        }
        int[] answer = new int[list.size()];
        int index = 0;
        for (int a = 0; a < list.size(); a++) answer[index++] = list.get(a);
        return answer;
    }
}