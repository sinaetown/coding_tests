import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[100][100];
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int xStart = Integer.parseInt(st.nextToken());
            int yStart = Integer.parseInt(st.nextToken());
            int xEnd = xStart + 10;
            int yEnd = yStart + 10;
            for (int x = xStart; x < xEnd; x++) {
                for (int y = yStart; y < yEnd; y++) {
                    if (grid[x][y] == 0) {
                        grid[x][y] = 1;
                    } else {
                        grid[x][y] += 1;
                    }
                }
            }
        }
        int answer = 0;
        int cnt = 0;
        for (int a = 0; a < grid.length; a++) {
            for (int b = 0; b < grid[a].length; b++) {
                if (grid[a][b] == 1) {
                    answer += grid[a][b];
                } else if (grid[a][b] > 1) {
//                    System.out.println(a + " " + b + "===> " + grid[a][b]);
                    answer -= grid[a][b] - 1;
                    cnt += grid[a][b] - 1;
                }
            }
        }
//        System.out.println(answer);
        System.out.println(100 * N - cnt);
    }
}