import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq2.add(Integer.parseInt(st.nextToken()));
        }
        int answer =0 ;
        while(!pq1.isEmpty()){
            answer += pq1.poll()* pq2.poll();
        }
        System.out.println(answer);
    }
}