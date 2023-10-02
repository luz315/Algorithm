import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> s = new Stack<>();
        int result = 0;
        for(int i =0; i<moves.length;i++){
            for(int j =0; j<board.length;j++){
                if(board[j][moves[i]-1]!=0){
                    if(!s.empty() && s.peek() == board[j][moves[i]-1]){
                        result ++;
                        s.pop();
                        board[j][moves[i]-1] = 0;
                        break;
                    }
                    else{
                        s.push(board[j][moves[i]-1]);
                        board[j][moves[i]-1]=0;
                        break;
                    }
                }
            }
        }
        return result*2;
  
    }
}