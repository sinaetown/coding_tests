import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static int[][] grid;
    public static boolean[][] appleGrid;
    public static int[] seconds;
    public static char[] directions;

    public static int[] dx = {0, 1, 0, -1}; //동 남 서 북
    public static int[] dy = {1, 0, -1, 0};

    public static int directionIndex = 0;
    public static int n;
    public static Deque<int[]> snake = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int apples = Integer.parseInt(br.readLine());
        grid = new int[n][n]; //(0,0)으로 시작
        appleGrid = new boolean[n][n];

        for (int i = 0; i < apples; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            appleGrid[r][c] = true;
        }
        int l = Integer.parseInt(br.readLine());
        seconds = new int[l];
        directions = new char[l];

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            seconds[i] = sec;
            directions[i] = dir;
        }
        System.out.println(play());
    }

    public static int play() {
        int currentTime = 0;
        int dirInd = 0;
        int x = 0, y = 0;
        snake.add(new int[]{x, y});
        grid[x][y] = 1;
        while (true) {
            currentTime++;
            int nx = dx[directionIndex] + x;
            int ny = dy[directionIndex] + y;
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (grid[nx][ny] == 0) {
                    snake.add(new int[]{nx, ny}); //머리 추가
                    grid[nx][ny] = 1;
                    if (!appleGrid[nx][ny]) { //사과가 없다면 꼬리 제거
                        int[] tail = snake.poll();
                        grid[tail[0]][tail[1]] = 0;
                    } else {
                        appleGrid[nx][ny] = false; //사과 먹음
                    }
                    x = nx;
                    y = ny;
                }
                else break;
            } else break;
            if (dirInd < seconds.length && currentTime == seconds[dirInd]) {
                rotate(directions[dirInd]);
                dirInd++;
            }
        }
        return currentTime;
    }

    public static void rotate(char c) {
        if (c == 'L') directionIndex = (directionIndex + 3) % 4;
        else if (c == 'D') directionIndex = (directionIndex + 1) % 4;
    }
}