class Solution {
    public int solution(int[][] triangle) {
        int[][] arr = new int[triangle.length][triangle.length];
        int answer = 0; 
        if(triangle.length==1){
            answer = triangle[0][0];
            return answer;
        }
        else{
        arr[0][0] = triangle[0][0];
        arr[1][0] = arr[0][0] + triangle[1][0];
        arr[1][1] = arr[0][0] + triangle[1][1];

        for (int i = 2; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) arr[i][j] = arr[i - 1][j] + triangle[i][j];
                else if (j == triangle[i].length - 1) arr[i][j] = arr[i - 1][triangle[i-1].length - 1] + triangle[i][j];
                else {
                    //(2,1)은 (1,0)또는(1,1)에서 나옴
                      if (arr[i - 1][j - 1] + triangle[i][j] < arr[i - 1][j] + triangle[i][j]) {
                            arr[i][j] = arr[i - 1][j] + triangle[i][j];
                        } else {
                            arr[i][j] = arr[i - 1][j - 1] + triangle[i][j];
                        }
                }
            }
        }

        int max = -1;
        for (int a : arr[triangle.length - 1]) {
            if (max < a) {
                max = a;
            }
        }
        answer = max;
        return answer;
        }
        
    }
}