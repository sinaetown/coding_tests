import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
        String s = "";
        Double sum = 0.0;
        int count = 0;
        for(int i = 0; i <20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            Double credit = Double.parseDouble(st.nextToken());
            Double grade = map.get(st.nextToken());
            if(grade!=null) {
                sum += credit * grade;
                count+=credit;
            }

        }
        bw.write((sum / count)+"\n");
        bw.flush();
        bw.close();


    }

}