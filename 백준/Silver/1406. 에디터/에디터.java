import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] word = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<Character>();
        for (char w : word) list.add(w);
        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            char c = cmd.charAt(0);
            switch (c) {
                case 'L':
                    if (iter.hasPrevious())
                        iter.previous();

                    break;
                case 'D':
                    if (iter.hasNext())
                        iter.next();

                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char t = cmd.charAt(2);
                    iter.add(t);
                    break;
                default:
                    break;
            }
        }
        for (char ch : list) {
            sb.append(ch);
        }
        System.out.println(sb);
    }
}