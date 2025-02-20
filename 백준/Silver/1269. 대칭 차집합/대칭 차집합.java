import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] read = new int[2];
        for (int i = 0; i < 2; i++) {
            read[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i < read[0]; i++) listA.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine(), " ");
        HashSet<Integer> setB = new HashSet<>();
        for (int i = 0; i < read[1]; i++) setB.add(Integer.parseInt(st.nextToken()));

        int count = 0;
        for (int i = 0; i < listA.size(); i++) {
            if (setB.contains(listA.get(i))) count++;
        }
        System.out.println(read[0] + read[1] - count * 2);
    }
}