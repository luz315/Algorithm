import java.util.*;
import java.io.*;
public class Main{
    static boolean board[][]; 
    static int result =Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];
        
        for(int i=0; i<N; i++){ // 행
            String str = br.readLine();
            for(int j=0; j<M; j++){ //열
                board[i][j]=(str.charAt(j)=='W');
            }
        }
        
        //체스판 만들기
        for(int i =0; i<=N-8; i++){
            for(int j=0; j<=M-8;j++){
                result = Math.min(count(i,j), result);
            }
        }
        
        System.out.println(result);
    }
    
    public static int count(int x, int y){
       
        int count = 0; 
        boolean color = board[x][y];
        
        for(int i =x; i <x+8; i++){
            for(int j =y; j<y+8; j++){
                if(board[i][j]!=color){
                    count++;
                }
                color = !color;
            }
            color = !color;
        }
        
        return Math.min(count, 64-count);
    }
}