import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long total = Long.parseLong(br.readLine()) * Long.parseLong(br.readLine()) * Long.parseLong(br.readLine());
        int[] arr = new int[10];
        String converted = String.valueOf(total);
        for (int i = 0; i < converted.length(); i++) {
            arr[converted.charAt(i) - '0']++;
        }
        for (int i : arr) bw.write(i + "\n");
        bw.flush();
        bw.close();
    }
}