import java.io.*;
import java.util.*;

public class Main {
    public static int[][] grid;
    public static int[] dx = {0, 0, -1, 1}; //동서북남
    public static int[] dy = {1, -1, 0, 0};
    public static int n;
    public static int m;
    public static int currentX;
    public static int currentY;

    public static class Dice {
        int top;
        int bottom;
        int right;
        int left;
        int front;
        int rear;

        public Dice(int top, int bottom, int right, int left, int front, int rear) {
            this.top = top;
            this.bottom = bottom;
            this.right = right;
            this.left = left;
            this.front = front;
            this.rear = rear;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        currentX = Integer.parseInt(st.nextToken());
        currentY = Integer.parseInt(st.nextToken());
        int o = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        Dice currentDice = new Dice(0, 1, 2, 3, 4, 5);
        int[] dice = new int[6];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < o; i++) {
            int k = Integer.parseInt(st.nextToken());
            int top = currentDice.top;
            int bottom = currentDice.bottom;
            int right = currentDice.right;
            int left = currentDice.left;
            int front = currentDice.front;
            int rear = currentDice.rear;
            Dice nextDice = null;
            if (k == 1) { //동쪽으로 굴려
                nextDice = new Dice(left, right, top, bottom, front, rear);
            } else if (k == 2) { //서쪽으로 굴려
                nextDice = new Dice(right, left, bottom, top, front, rear);
            } else if (k == 3) { //북쪽으로 굴려
                nextDice = new Dice(front, rear, right, left, bottom, top);
            } else if (k == 4) { //남쪽으로 굴려
                nextDice = new Dice(rear, front, right, left, top, bottom);
            }
            int nextX = dx[k - 1] + currentX;
            int nextY = dy[k - 1] + currentY;
            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                currentDice = nextDice;
                currentX = nextX;
                currentY = nextY;
                if (grid[currentX][currentY] == 0) {
                    grid[currentX][currentY] = dice[currentDice.bottom];
                } else {
                    dice[currentDice.bottom] = grid[currentX][currentY];
                    grid[currentX][currentY] = 0;
                }
                System.out.println(dice[currentDice.top]);
            }
        }
    }
}