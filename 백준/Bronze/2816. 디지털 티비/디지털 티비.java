import java.io.*;
import java.util.*;

public class Main {
    public static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        int pointer = 0;
        //1->4 == 3
        while (!arr[0].equals("KBS1")) {
            // kbs1까지 도달
            int index = find("KBS1");
            for (int i = 0; i < index; i++) {
                pointer++;
                bw.write("1");
            }
            for (int i = index; i > 0; i--) {
                String tmp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = tmp;
                pointer--;
                bw.write("4");
            }
        }
        while (!arr[1].equals("KBS2")) {
            int index = find("KBS2");
            for (int i = 0; i < index; i++) {
                pointer++;
                bw.write("1");
            }
            for (int i = index; i > 1; i--) {
                String tmp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = tmp;
                pointer--;
                bw.write("4");
            }
        }
        bw.flush();
    }

    public static int find(String s) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(s)) return i;
        }
        return -1;
    }
}