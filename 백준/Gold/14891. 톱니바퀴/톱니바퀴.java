import java.io.*;
import java.util.*;

public class Main {
    static char[] a;
    static char[] b;
    static char[] c;
    static char[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        c = br.readLine().toCharArray();
        d = br.readLine().toCharArray();
        // index 2랑 6이 맞닿아있음

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int device = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            if (direction == 1) operateclock(device);
            else if (direction == -1) operatecounter(device);

        }
        int sum = 0;
        sum += (a[0] == '0') ? 0 : 1;
        sum += (b[0] == '0') ? 0 : 2;
        sum += (c[0] == '0') ? 0 : 4;
        sum += (d[0] == '0') ? 0 : 8;
        System.out.println(sum);
    }

    public static void operatecounter(int device) {
        char[] compare_a = a.clone();
        char[] compare_b = b.clone();
        char[] compare_c = c.clone();
        char[] compare_d = d.clone();
        if (device == 1) {
            a = counterclockwise(a);
            if (compare_a[2] != compare_b[6]) {
                b = clockwise(b);
                if (compare_b[2] != compare_c[6]) {
                    c = counterclockwise(c);
                    if (compare_c[2] != compare_d[6]) {
                        d = clockwise(d);
                    }
                }
            }
        } else if (device == 4) {
            d = counterclockwise(d);
            if (compare_c[2] != compare_d[6]) {
                c = clockwise(c);
                if (compare_b[2] != compare_c[6]) {
                    b = counterclockwise(b);
                    if (compare_a[2] != compare_b[6]) {
                        a = clockwise(a);
                    }
                }
            }
        } else if (device == 2) {
            b = counterclockwise(b);
            if (compare_a[2] != compare_b[6]) {
                a = clockwise(a);
            }
            if (compare_b[2] != compare_c[6]) {
                c = clockwise(c);
                if (compare_c[2] != compare_d[6]) {
                    d = counterclockwise(d);
                }
            }
        } else if (device == 3) {
            c = counterclockwise(c);
            if (compare_c[2] != compare_d[6]) {
                d = clockwise(d);
            }
            if (compare_b[2] != compare_c[6]) {
                b = clockwise(b);
                if (compare_a[2] != compare_b[6]) {
                    a = counterclockwise(a);
                }
            }
        }
    }

    public static void operateclock(int device) {
        char[] compare_a = a.clone();
        char[] compare_b = b.clone();
        char[] compare_c = c.clone();
        char[] compare_d = d.clone();
        if (device == 1) {
            a = clockwise(a);
            if (compare_a[2] != compare_b[6]) {
                b = counterclockwise(b);
                if (compare_b[2] != compare_c[6]) {
                    c = clockwise(c);
                    if (compare_c[2] != compare_d[6]) {
                        d = counterclockwise(d);
                    }
                }
            }
        } else if (device == 4) {
            d = clockwise(d);
            if (compare_c[2] != compare_d[6]) {
                c = counterclockwise(c);
                if (compare_b[2] != compare_c[6]) {
                    b = clockwise(b);
                    if (compare_a[2] != compare_b[6]) {
                        a = counterclockwise(a);
                    }
                }
            }
        } else if (device == 2) {
            b = clockwise(b);
            if (compare_a[2] != compare_b[6]) {
                a = counterclockwise(a);
            }
            if (compare_b[2] != compare_c[6]) {
                c = counterclockwise(c);
                if (compare_c[2] != compare_d[6]) {
                    d = clockwise(d);
                }
            }
        } else if (device == 3) {
            c = clockwise(c);
            if (compare_c[2] != compare_d[6]) {
                d = counterclockwise(d);
            }
            if (compare_b[2] != compare_c[6]) {
                b = counterclockwise(b);
                if (compare_a[2] != compare_b[6]) {
                    a = clockwise(a);
                }
            }
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
