import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        int[] arr = new int[26];
        for (int j = 0; j < line.length(); j++) {
            arr[line.charAt(j) - 'a']++;
        }
        for (int a : arr) bw.write(a + " ");
        bw.flush();
        bw.close();
    }
}