import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] grid = new int[H][W];
        int[] water = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int w = 0; w < water.length; w++) {
            water[w] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < water[s]; j++) {
                grid[j][i] = 1; // block
            }
            s++;
        }
        System.out.println(fillWater(grid));
    }

    public static int fillWater(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 1) {
                    if (i == 0 || grid[i - 1][j] != 0) { //아래에 물이든 블록이든 차있음
                        int iLeft = j + 1;
                        int iRight = j - 1;
                        boolean leftFlag = false;
                        boolean rightflag = false;
                        while (iLeft < grid[i].length) {
                            if (grid[i][iLeft] != 0) { //물이든 블록이든
                                leftFlag = true;
                                break;
                            }
                            iLeft++;
                        }
                        while (iRight >= 0) {
                            if (grid[i][iRight] != 0) { //물이든 블록이든
                                rightflag = true;
                                break;
                            }
                            iRight--;
                        }
                        if (leftFlag && rightflag) {
                            grid[i][j] = 2; //물 차있음
                            answer++;
                        }
                    }
                }
            }
        }
        return answer;
    }
}