import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> areaList;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        int[] dx = {1, 0}; //right, down
        int[] dy = {0, 1}; //right, down
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        areaList = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            String line = br.readLine();
            for (int m = 0; m < M; m++) {
                matrix[n][m] = Integer.parseInt(line.substring(m, m + 1));
            }
        }
        findArea();
        System.out.println(areaList.stream().mapToInt(a -> a).max().getAsInt());
    }

    static void findArea() {
        int area = 0;
        for (int a = 0; a < matrix.length; a++) {
            area = 0;
            for (int b = 0; b < matrix[a].length; b++) {
                int num = matrix[a][b]; //left top
                for (int c = matrix[a].length-1; c > b; c--) {
                    if (matrix[a][c] == num) { //right top
                        for (int d = matrix.length-1; d > a; d--) {
                            if (matrix[d][b] == num) { // left bottom
                                if (matrix[d][c] == num) { //right bottom
//                                    System.out.printf("a,b (%d, %d) => %d\n", a, b, matrix[a][b]);
//                                    System.out.printf("d,c (%d, %d) => %d\n", d, c, matrix[d][c]);
                                    if(d - a + 1==c - b + 1){
                                        area = (d - a + 1) * (c - b + 1);
                                    }
                                    else{
                                        continue;
                                    }
                                    areaList.add(area);
//                                    System.out.println(area);
//                                    System.out.println(areaList);
                                }
                            }
                        }
                    }
                }
            }
        }
        areaList.add(1);
    }
}
