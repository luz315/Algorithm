import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int dp[] = new int[11];
        
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        
        
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            
            
            for(int i=4; i<=N; i++){
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            }
            System.out.println(dp[N]);
        }
    }
}