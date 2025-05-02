import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String number = String.valueOf(num);
        int[] arr = new int[10];
        int max = Integer.MIN_VALUE;
        int chk = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) - '0' == 6 || number.charAt(i) - '0' == 9) {
                if (arr[9] != arr[6]) {
                    if (arr[9] < arr[6]) arr[9]++;
                    else arr[6]++;
                } else arr[number.charAt(i) - '0']++;
            } else arr[number.charAt(i) - '0']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}