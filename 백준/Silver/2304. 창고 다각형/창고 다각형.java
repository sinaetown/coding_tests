import java.io.*;
import java.util.*;

public class Main {
    public static class Bar {
        int start;
        int height;

        public Bar(int start, int height) {
            this.start = start;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Bar> list = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            Bar info = new Bar(start, height);
            list.add(info);
        }
        list.sort(new Comparator<Bar>() {
            @Override
            public int compare(Bar o1, Bar o2) {
                return o1.start - o2.start;
            }
        });
        int index = 0;
        int max = -1;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i).height) {
                max = list.get(i).height;
                index = i;
            }
        }
        int area = 0;
        //왼쪽
        int leftStart = list.get(0).start;
        int leftHeight = list.get(0).height;
        for (int i = 0; i <= index; i++) {
            if (leftHeight <= list.get(i).height) {
                area += leftHeight * (list.get(i).start - leftStart);
                leftStart = list.get(i).start;
                leftHeight = list.get(i).height;
            }
        }

        //오른쪽
        int rightStart = list.get(list.size() - 1).start;
        int rightHeight = list.get(list.size() - 1).height;
        for (int i = list.size() - 1; i >= index; i--) {
            if (rightHeight <= list.get(i).height) {
                area += rightHeight * (rightStart - list.get(i).start);
                rightHeight = list.get(i).height;
                rightStart = list.get(i).start;
            }
        }
        area += max;
        System.out.println(area);
    }
}