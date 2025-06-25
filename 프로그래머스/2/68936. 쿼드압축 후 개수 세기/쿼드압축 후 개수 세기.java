class Solution {
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        chk(arr, arr.length, 0, 0);
        return answer;
    }
    
    public static void chk(int[][] arr, int size, int x, int y){
        int num = arr[x][y];
        if(size == 1) {
            answer[num]++;
            return;
        }
        if(isPossible(arr, size, x, y)) { // increment by one
            answer[num]++;
            return;
        }
        else { //break down
            chk(arr, size/2, x, y); // 1
            chk(arr, size/2, x+size/2, y); // 2
            chk(arr, size/2, x, y+size/2); // 3
            chk(arr, size/2, x+size/2, y+size/2); // 4
        }
    }
    
    public static boolean isPossible(int[][] arr, int size, int x, int y){
        int num = arr[x][y];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(num!=arr[x+i][y+j]) return false;
            }
        }
        return true;
    }
}