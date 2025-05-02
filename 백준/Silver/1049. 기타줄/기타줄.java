import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> packPq = new PriorityQueue<>();
        PriorityQueue<Integer> indPq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int ind = Integer.parseInt(st.nextToken());
            packPq.add(pack);
            indPq.add(ind);
        }
        //ind만으로 샀을 때
        int first = indPq.peek() * n;
        //pack만으로 샀을 때
        int second = packPq.peek() * ((n / 6) + 1);
        //ind + pack
        int third = 0;
        int p = n / 6;
        third += packPq.peek() * p;
        n = n - p * 6;
        third += (n * indPq.peek());
        PriorityQueue<Integer> answerPq = new PriorityQueue<>();
        answerPq.add(first);
        answerPq.add(second);
        answerPq.add(third);
        System.out.println(answerPq.poll());
    }
}