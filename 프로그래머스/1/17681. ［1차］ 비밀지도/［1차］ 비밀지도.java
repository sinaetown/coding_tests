class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2){
        String[] answer = new String[arr1.length];
        String[][] grid = new String[arr1.length][arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            String s = Integer.toBinaryString(arr1[i]);
            if (s.length() < arr1.length) {
                int len = s.length();
                for (int j = 0; j < arr1.length - len; j++) {
                    s = "0" + s;
                }
            }
            for (int b = 0; b < s.length(); b++) {
                if (s.charAt(b) == '1') {
                    grid[i][b] = "#";
                } else grid[i][b] = " ";
            }
        }

        for (int z = 0; z < arr2.length; z++) {
            String s = Integer.toBinaryString(arr2[z]);
            if (s.length() < arr2.length) {
                int len = s.length();
                for (int x = 0; x < arr2.length - len; x++) {
                    s = "0" + s;
                }
            }
            for (int b = 0; b < s.length(); b++) {
                if (s.charAt(b) == '1') {
                    grid[z][b] = "#";
                } else if (grid[z][b] == " " && s.charAt(b) == '0') grid[z][b] = " ";
            }
        }

        for (int q = 0; q < grid.length; q++) {
            String together = "";
            for (int p = 0; p < grid[q].length; p++) {
                together += grid[q][p];
            }
            answer[q] = together;
        }
        return answer;
    }
}