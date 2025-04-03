import java.io.*;
import java.util.*;

public class Main {

    public static class Element {
        int length;
        int freq;
        String word;

        public Element(int length, int freq, String word) {
            this.length = length;
            this.freq = freq;
            this.word = word;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Element> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int n = 0; n < N; n++) {
            String w = br.readLine();
            if (w.length() >= M) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            list.add(new Element(entry.getKey().length(), entry.getValue(), entry.getKey()));
        }
        list.sort(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if ((o1.freq == o2.freq) && (o1.length == o2.length)) {
                    return o1.word.compareTo(o2.word);
                } else if (o1.freq == o2.freq) {
                    return o2.length - o1.length;
                }
                return o2.freq - o1.freq;
            }
        });
        for (Element e : list) {
            bw.write(e.word+"\n");
        }
        bw.flush();
        bw.close();
    }
}