import java.util.*;

class Solution {
    public static int[][] book;
    public int solution(String[][] book_time) {
        book = new int[book_time.length][2];
        int answer = 0;
        toMin(book_time);
        
        Arrays.sort(book, (a1, a2) -> {
            return a1[0] - a2[0]; // 오름차순
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        for(int[] b : book){
            if(pq.isEmpty()) pq.add(b);
            else{
                int[] peeked = pq.peek();
                if(b[0] >= peeked[1]) pq.poll();
                pq.add(b);
            }
        }
        return pq.size();
    }
    
    public static void toMin(String[][] book_time){
        for(int i = 0; i < book_time.length; i++){
            String[] start = book_time[i][0].split(":");
            int startHr = Integer.parseInt(start[0]);
            int startMin = Integer.parseInt(start[1]);
            String[] end = book_time[i][1].split(":");
            int endHr = Integer.parseInt(end[0]);
            int endMin = Integer.parseInt(end[1])+10;
            book[i][0] = startHr*60+startMin;
            book[i][1] = endHr*60+endMin;
        }
    }
}