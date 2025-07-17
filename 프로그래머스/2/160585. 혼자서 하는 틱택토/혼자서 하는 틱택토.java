import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        //둘 다 틱택토일 수 없음
        int cntO = count(board, 'O');
        int cntX = count(board, 'X');
        if(isTicTacToe(board, 'X') && isTicTacToe(board, 'O')) return 0;
        //X의 개수가 O의 개수보다 더 많을 수 없음
        if(cntX > cntO) return 0;
        if(Math.abs(cntX-cntO) > 1) return 0;
        if(isTicTacToe(board, 'X')){
            if(cntX != cntO) return 0;
        }
        if(isTicTacToe(board, 'O')){
            if(cntX >= cntO) return 0;
        }
        return 1;
    }
    
    public boolean isTicTacToe(String[] board, char c){
        if(chkDiagnoal(board, c) || chkVertical(board, c) || chkHorizontal(board, c)) return true;
        return false;
    }
    
    public boolean chkDiagnoal(String[] board, char c){
        if(board[0].charAt(0) == c && board[0].charAt(0) == board[1].charAt(1) 
           && board[1].charAt(1) == board[2].charAt(2)) return true;
        if(board[0].charAt(2) == c && board[0].charAt(2) == board[1].charAt(1) 
           && board[1].charAt(1) == board[2].charAt(0)) return true;
        return false;
    }
    
    public boolean chkVertical(String[] board, char c){
        for(int i = 0 ; i < 3; i++){
            if(board[0].charAt(i) == c && board[0].charAt(i) == board[1].charAt(i) 
               && board[0].charAt(i) == board[2].charAt(i)) return true;
        }
        return false;
    }
    
    public boolean chkHorizontal(String[] board, char c){
        for(int i = 0 ; i < 3; i++){
            if(board[i].charAt(0) == c && board[i].charAt(0) == board[i].charAt(1)
               && board[i].charAt(0) == board[i].charAt(2)) return true;
        }
        return false;
    }
    
    public int count(String[] board, char c){
        int cnt = 0;
        for(int i = 0 ; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j) == c) cnt++;
            }
        }
        return cnt;
    }
}