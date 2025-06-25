class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for(int i = 0; i < wallpaper.length; i++){
            String s = wallpaper[i];
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j)=='#'){
                    int[] upperLeft = new int[]{i,j};
                    int[] lowerRight = new int[]{i+1, j+1};
                    if(minX > upperLeft[0]) minX = upperLeft[0];
                    if(minY > upperLeft[1]) minY = upperLeft[1];
                    if(maxX < lowerRight[0]) maxX = lowerRight[0];
                    if(maxY < lowerRight[1]) maxY = lowerRight[1];
                }
            }
        }
        return new int[]{minX, minY, maxX, maxY};
    }
}