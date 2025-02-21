import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] grid = new char[N][M];
        for (int n = 0; n < N; n++) {
            String line = br.readLine();
            for (int m = 0; m < M; m++) {
                grid[n][m] = line.charAt(m);
            }
        }
        int countCuts = (N - 7) * (M - 7);
        int cnt = 0;
        int initA = 0;
        int initB = 0;
        while (cnt < countCuts) {
            char[][] cut = new char[8][8];
            int startA = initA;
            for (int a = 0; a < 8; a++) {
                int startB = initB;
                for (int b = 0; b < 8; b++) {
                    cut[a][b] = grid[startA][startB];
                    startB++;
                }
                startA++;
                if (startA >= N) break;
            }
            set.add(Math.min(count(cut, 'B'), count(cut, 'W')));
            cnt++;
            if (initB == M - 8) {
                initA++;
                initB = 0;
            } else {
                initB++;
            }
        }
        System.out.println(set.iterator().next());
    }

    public static int count(char[][] grid, char upperLeft) {
        int cnt = 0;
        if (upperLeft == 'B') {
            for (int n = 0; n < 8; n++) {
                for (int m = 0; m < 8; m++) {
                    if ((isEven(n) && isEven(m) && grid[n][m] == 'W')
                            || (!isEven(n) && !isEven(m) && grid[n][m] == 'W')) {
                        cnt++;
                    } else if ((!isEven(n) && isEven(m) && grid[n][m] == 'B')
                            || (isEven(n) && !isEven(m) && grid[n][m] == 'B')) {
                        cnt++;
                    }
                }
            }
        } else if (upperLeft == 'W') {
            for (int n = 0; n < 8; n++) {
                for (int m = 0; m < 8; m++) {
                    if ((isEven(n) && isEven(m) && grid[n][m] == 'B')
                            || (!isEven(n) && !isEven(m) && grid[n][m] == 'B')) {
                        cnt++;
                    } else if ((!isEven(n) && isEven(m) && grid[n][m] == 'W')
                            || (isEven(n) && !isEven(m) && grid[n][m] == 'W')) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static boolean isEven(int i) {
        return i % 2 == 0;
    }

}