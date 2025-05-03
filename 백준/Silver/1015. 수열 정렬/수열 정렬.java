import java.io.*;
import java.util.*;

public class Main {
    public static class Element {
        int index;
        int number;

        public Element(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Element> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int read = Integer.parseInt(st.nextToken());
            list.add(new Element(i, read));
        }
        list.sort(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.number - o2.number;
            }
        });
        int[] arr = new int[n];
        int a = 0;
        for (Element e : list) {
            arr[e.index] = a++;
        }
        for (int j : arr) System.out.print(j + " ");
    }
}