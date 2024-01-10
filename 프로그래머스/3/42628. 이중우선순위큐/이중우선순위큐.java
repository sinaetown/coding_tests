import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq_asc = new PriorityQueue<>(); //default = ascending ->
        int[] answer = new int[2];
        int len = 0;
        for (String o : operations) {
            StringTokenizer st = new StringTokenizer(o);
            String cmd = st.nextToken();
            String num = st.nextToken();
            if (cmd.equals("I")) {
                pq_asc.add(Integer.parseInt(num));
            } else if (cmd.equals("D")) {
                if (num.equals("1")) {
                    PriorityQueue<Integer> pq_desc = new PriorityQueue<>(Collections.reverseOrder());
                    pq_desc.addAll(pq_asc);
//                        System.out.println("DESC: " + pq_desc);
                    pq_desc.poll();
                    pq_asc = new PriorityQueue<>();
                    pq_asc.addAll(pq_desc);
                    // System.out.println("when : " + num + " " + pq_asc);
                    // System.out.println("here");
                } else if (num.equals("-1")) {
                    pq_asc.poll();
                    // System.out.println(pq_asc.poll());
                    // System.out.println("After: " + pq_asc);
                }
            }
        }
        if (pq_asc.size() == 0) {
            System.out.println("[0,0]");
             answer[0]=0;
            answer[1]=0;
            return answer;
//            return "[0,0]";
        } else {
            PriorityQueue<Integer> pq_desc = new PriorityQueue<>(Collections.reverseOrder());
            pq_desc.addAll(pq_asc);
            answer[0] = pq_desc.poll();
            answer[1] = pq_asc.poll();
            // System.out.println(Arrays.toString(answer));
            return answer;
        }
        
    }
}