import java.util.*;

class Solution {
    public static class File {
        String head;
        String number;
        String tail;
        int index;

        public File(String head, String number, String tail, int index) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.index = index;
        }

        public String getHead() {
            return head;
        }

        public String getNumber() {
            return number;
        }

        public String getTail() {
            return tail;
        }

        public int getIndex() {
            return index;
        }
    }

    public static String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        int index = 0;
        for (String f : files) {
            String head = "";
            String strNum = "";
            String tail = "";
            boolean headDone = false;
            boolean tailStart = false;
             for (int i = 0; i < f.length(); i++) {
                if (!Character.isDigit(f.charAt(i)) && !headDone) {
                    head += f.charAt(i);
                } else if (Character.isDigit(f.charAt(i)) & !tailStart) {
                    strNum += f.charAt(i);
                    headDone = true;
                } else if (headDone) {
                    tailStart=true;
                    tail += f.charAt(i);
                }
            }
            fileList.add(new File(head, strNum, tail, index++));
        }
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.getHead().toLowerCase().compareTo(o2.getHead().toLowerCase()) != 0) {
                    return o1.getHead().toLowerCase().compareTo(o2.getHead().toLowerCase());
                }
                if (o1.getHead().toLowerCase().compareTo(o2.getHead().toLowerCase()) == 0
                        && Integer.parseInt(o1.getNumber()) - Integer.parseInt(o2.getNumber()) != 0) {
                    return Integer.parseInt(o1.getNumber()) - Integer.parseInt(o2.getNumber());
                }
                return o1.getIndex()-o2.getIndex();
            }
        });
        String[] answer = new String[files.length];
        int ind = 0;
         for (File f : fileList) {
            answer[ind++] = files[f.getIndex()];
        }
        return answer;
    }
}