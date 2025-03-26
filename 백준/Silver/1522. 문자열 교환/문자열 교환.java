import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int aSize = 0;
        for (int i = 0; i < line.length(); i++) { //a 개수 세기
            if (line.charAt(i) == 'a') {
                aSize++;
            }
        }
        int start = 0, bCnt = 0, end = aSize - 1;
        for (int i = 0; i < aSize; i++) { // 범위 안에 있는 b 개수 세기
            if (line.charAt(i) == 'b') bCnt++;
        }
        int min = bCnt;
        while (start < line.length()) {
            if (line.charAt(++end % line.length()) == 'b') {
                bCnt++;
            }
            if (line.charAt(start++) == 'b') bCnt--;
            min = Math.min(bCnt, min);
        }
        System.out.println(min);
    }

}
