import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] given;
    static int[] know;
    static List<Integer> avoid = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        given = new List[n + 1];
        int answer = 0;
        List<Set<Integer>> parties = new ArrayList<>();
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            given[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        if (k != 0) {
            know = new int[k];
            for (int i = 0; i < k; i++) {
                int z = Integer.parseInt(st.nextToken());
                know[i] = z;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            Set<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < a; j++) {
                int z = Integer.parseInt(st.nextToken());
                list.add(z);
                set.add(z);
            }
            parties.add(new HashSet<>(set));
            make(list);
        }
        if (k == 0) {
            bw.write(String.valueOf(m));
            bw.flush();
            bw.close();
            return;
        }
//        System.out.println("know: " + Arrays.toString(know));
//        System.out.println("given: " + Arrays.toString(given));
//        System.out.println("parties: " + parties);
        for (int a = 0; a < know.length; a++) {
            avoid.add(know[a]);
            bfs(know[a]);
        }
//        System.out.println("avoid: " + avoid);
        for (int i = 0; i < parties.size(); i++) {
            boolean chk = false;
            for (int j = 0; j < avoid.size(); j++) {
                if (parties.get(i).contains(avoid.get(j))) {
                    chk = true;
                    break;
                }
            }
            if (!chk) answer++;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void make(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (!given[list.get(i)].contains(list.get(j))) {
                    given[list.get(i)].add(list.get(j));
                }
                if (!given[list.get(j)].contains(list.get(i))) {
                    given[list.get(j)].add(list.get(i));
                }
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        if (given[start] != null) {
            List<Integer> l = given[start];
            for (int i = 0; i < l.size(); i++) {
                q.add(l.get(i));
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int polled = q.poll();
                if (!avoid.contains(polled)) {
                    avoid.add(polled);
                }
                if (!visited[polled]) {
                    visited[polled] = true;
                    if (given[polled] == null) continue;
                    List<Integer> polledList = given[polled];
                    for (int j = 0; j < polledList.size(); j++) {
                        q.add(polledList.get(j));
                    }
                }
            }
        }

    }
}