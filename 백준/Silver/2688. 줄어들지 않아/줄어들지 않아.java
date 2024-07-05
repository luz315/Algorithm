import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long dp[][] = new long[65][10];
        
        for(int i=0; i<10; i++){
            dp[1][i]=1;
        }
        
        for(int i=2; i<65; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<=j; k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            long result =0;
            for(int i=0; i<10; i++){
                result += dp[N][i]; 
            }
            System.out.println(result);
        }
    }
}