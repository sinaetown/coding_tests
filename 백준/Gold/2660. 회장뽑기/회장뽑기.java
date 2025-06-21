import java.io.*;
import java.util.*;

public class Main {
    public static int n;

    public static List<List<Integer>> list = new ArrayList<>();
    public static int[][] grid;
    public static List<int[]> score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        grid = new int[n + 1][n + 1];
        score = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) list.add(new ArrayList<>());
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                grid[i][j] = 100;
            }
        }
        while (true) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if (first == -1 && second == -1) break;
            grid[first][second] = 1;
            grid[second][first] = 1;
            list.get(first).add(second);
            list.get(second).add(first);
        }
        floyd();
//        System.out.println(list);
//        System.out.println(Arrays.deepToString(grid));
        for (int i = 0; i < n + 1; i++) {
            int a = -1;
            for (int j = 0; j < n + 1; j++) {
                if (i != j && i != 0 && j != 0 && grid[i][j] != 100) a = Math.max(a, grid[i][j]);
            }
            score.add(new int[]{i, a}); // number, score
        }
        score.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int rankScoreMin = score.get(1)[1];
//        System.out.println(rankScoreMin);

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < score.size(); i++) {
            if (score.get(i)[1] == rankScoreMin) answer.add(score.get(i)[0]);
        }
//        System.out.println(answer);
        bw.write(rankScoreMin + " " + answer.size() + "\n");
        for (int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i) + " ");
        }
        bw.flush();
        bw.close();
    }


    public static void floyd() {
        for (int k = 0; k < n + 1; k++) {
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    grid[i][j] = Math.min(grid[i][k] + grid[k][j], grid[i][j]);
                }
            }
        }
    }
}