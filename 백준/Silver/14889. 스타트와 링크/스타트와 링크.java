import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static int min = Integer.MAX_VALUE;
    static List<List<Integer>> total = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(N, visited, 0, new ArrayList<>(), new ArrayList<>(), 0, 0, 0);
        System.out.println(min);
    }


    // 1 3 6 = (1,3) + (3,1) + (3,6) + (6,3) + (1,6) + (6,1)
    public static void backtracking(int N, boolean[] visited, int count, List<Integer> start, List<Integer> link, int startSum, int linkSum, int initial) {
        if (count == N / 2) {
            link = new ArrayList<>();
            for (int b = 0; b < visited.length; b++) {
                if (!visited[b]) link.add(b);
            }
//            System.out.println("start: " + new ArrayList<>(start));
//            System.out.println("link: " + new ArrayList<>(link));
            for (int a = 0; a < start.size() - 1; a++) {
                for (int b = a + 1; b < start.size(); b++) {
                    startSum += grid[start.get(a)][start.get(b)] + grid[start.get(b)][start.get(a)];
                    linkSum += grid[link.get(a)][link.get(b)] + grid[link.get(b)][link.get(a)];
                }
            }
            if (min > Math.abs(startSum - linkSum)) min = Math.abs(startSum - linkSum);
            return;
        }
        for (int j = initial; j < N; j++) {
            if (!visited[j]) {
                visited[j] = true;
                start.add(j);
                count++;
                initial++;
                backtracking(N, visited, count, start, link, 0, 0, initial);
                count--;
                start.remove(start.size() - 1);
                visited[j] = false;
            }
        }
    }
}
