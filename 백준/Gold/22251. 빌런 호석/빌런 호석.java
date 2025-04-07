import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> list = new ArrayList<>();
    static int n;
    static int p;
    static int k;
    static int x;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        calculate();
        chk(0, 1, 0, 0);
        System.out.println(res-1);
    }


    public static void calculate() {
        list.add(new int[]{0, 4, 3, 3, 4, 3, 2, 3, 1, 2}); //0
        list.add(new int[]{4, 0, 5, 3, 2, 5, 6, 1, 5, 4}); //1
        list.add(new int[]{3, 5, 0, 2, 5, 4, 3, 4, 2, 3}); //2
        list.add(new int[]{3, 3, 2, 0, 3, 2, 3, 2, 2, 1}); //3
        list.add(new int[]{4, 2, 5, 3, 0, 3, 4, 3, 3, 2}); //4
        list.add(new int[]{3, 5, 4, 2, 3, 0, 1, 4, 2, 1}); //5
        list.add(new int[]{2, 6, 3, 3, 4, 1, 0, 5, 1, 2}); //6
        list.add(new int[]{3, 1, 4, 2, 3, 4, 5, 0, 4, 3}); //7
        list.add(new int[]{1, 5, 2, 2, 3, 2, 1, 4, 0, 1}); //8
        list.add(new int[]{2, 4, 3, 1, 2, 1, 2, 3, 1, 0}); //9
    }

    public static void chk(int where, int ten, int now, int changes) {
        if (changes > p || now > n) return;
        if (where == k) {
            if (now != 0) res++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            chk(where + 1, ten * 10, i * ten + now, changes + list.get(x / ten % 10)[i]);
        }
    }
}