import java.io.*;
import java.util.*;

public class Main {
    static char[][] gears = new char[4][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) gears[i] = br.readLine().toCharArray();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int device = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            rotate(device, direction);
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][0] == '1') {
                sum += (1 << i); // 1, 2, 4, 8
            }
        }
        System.out.println(sum);
    }

    public static void rotate(int device, int direction) {
        char[][] backup = new char[4][];
        for (int i = 0; i < 4; i++) backup[i] = gears[i].clone();
        int[] directions = new int[4];
        directions[device] = direction;

        //왼쪽으로 전파
        for (int i = device - 1; i >= 0; i--) {
            if (backup[i][2] != backup[i + 1][6]) {
                directions[i] = -directions[i + 1];
            } else break;
        }

        //오른쪽으로 전파
        for (int i = device + 1; i < 4; i++) {
            if (backup[i - 1][2] != backup[i][6]) {
                directions[i] = -directions[i - 1];
            } else break;
        }

        for (int i = 0; i < 4; i++) {
            if (directions[i] == 1) gears[i] = clockwise(gears[i]);
            else if (directions[i] == -1) gears[i] = counterclockwise(gears[i]);
        }
    }

    public static char[] clockwise(char[] arr) {
        char[] newArr = new char[arr.length];
        //0이 1에, 1이  2번에 , 2가 3에, 이.. 7이 0에
        for (int i = 0; i < arr.length; i++) {
            newArr[(i + 1) % arr.length] = arr[i];
        }
        return newArr;
    }

    public static char[] counterclockwise(char[] arr) {
        char[] newArr = new char[arr.length];
        //0은 7, 1은 0, 2는 1 ..
        for (int i = 0; i < arr.length; i++) {
            newArr[(arr.length - 1 + i) % arr.length] = arr[i];
        }
        return newArr;
    }

}
