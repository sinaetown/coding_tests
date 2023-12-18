import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, 0}; //right, down
    static int[] dy = {0, 1}; //right, down
    static int n;
    static String[][] matrix;
    static String temp;
    static String temp2;

    static List<Integer> rowCntList;
    static List<Integer> colCntList;

    static int rMax = 0;
    static int cMax = 0;
    static List<Integer> rMaxList = new ArrayList<>();
    static List<Integer> cMaxList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.substring(j, j + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    int x = dx[k] + i;
                    int y = dy[k] + j;
                    if (x >= 0 && y >= 0 && x < n && y < n) {
                        if (!matrix[i][j].equals(matrix[x][y])) {
                            temp = matrix[i][j];
                            matrix[i][j] = matrix[x][y];
                            matrix[x][y] = temp;
//                            System.out.println(Arrays.toString(matrix[i]));
//                            System.out.println("r: " +rowCnt(matrix));
//                            System.out.println("c: "+colCnt(matrix));
//                            maxList.add(Math.max(rowCnt(matrix), colCnt(matrix)));
                            rMaxList.add(rowCnt(matrix));
                            cMaxList.add(colCnt(matrix));
//                            rMax = rowCnt(matrix);
//                            cMax = colCnt(matrix);
                            temp2 = matrix[i][j];
                            matrix[i][j] = matrix[x][y];
                            matrix[x][y] = temp2;
                        }
//                        System.out.println();
                    }
                }
            }
        }
        cMaxList.sort(Comparator.reverseOrder());
        rMaxList.sort(Comparator.reverseOrder());
//        System.out.println(cMaxList);
//        System.out.println(rMaxList);
        System.out.println(Math.max(cMaxList.get(0),rMaxList.get(0)));

    }

    public static int rowCnt(String[][] matrix) {
        rowCntList = new ArrayList<>();
        int max = 0;
        int count=0;
        for (int i = 0; i < n; i++) {
            count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j].equals(matrix[i][j + 1])) {
                    count++;

                } else {
                    count = 1;
//                    rowCntList.add(count);
//                    count = 1;
                }
                max = Math.max(count, max);
            }
        }
//            System.out.println("MAX: "+max+"Count: "+count);
//            real_max= Math.max(max, count);
//            System.out.println("REALMax: "+real_max);
//            max =;
//            System.out.println("here:"+max);
//            System.out.println(count);
//            rowCntList.add(count);
//            rowCntList.sort(Comparator.reverseOrder());

        return Math.max(max, count);
    }

    public static int colCnt(String[][] matrix) {
        colCntList = new ArrayList<>();
        int max = 0;
        int count=0;
        for (int i = 0; i < n; i++) {
            count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (matrix[j][i].equals(matrix[j + 1][i])) {
                    count++;
                } else {
//                    System.out.println(count);
//                    colCntList.add(count);
//                    count = 1;

                    count = 1;
                }
                max = Math.max(count, max);
            }
//            System.out.println(max);
//            colCntList.add(count);
//            colCntList.sort(Comparator.reverseOrder());
        }
//        System.out.println("list: "+colCntList);
        return Math.max(max, count);
    }
}
