import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Set<String> dancing = new HashSet<>();
        dancing.add("ChongChong");
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            if (dancing.contains(line[0])) {
                dancing.add(line[1]);
            } else if (dancing.contains(line[1])) {
                dancing.add(line[0]);
            }
        }
        System.out.println(dancing.size());
    }

}