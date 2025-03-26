import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) set.add(br.readLine());
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            String[] split = line.split(",");
            for (int s = 0; s < split.length; s++) {
                if(set.contains(split[s])) set.remove(split[s]);
            }
            bw.write(set.size()+"\n");
        }
        bw.flush();
        bw.close();
    }

}
