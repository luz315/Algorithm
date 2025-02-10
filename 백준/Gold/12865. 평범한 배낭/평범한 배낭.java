import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N+1][2];
        int dp[] = new int[K+1];
        int result = 0;
        
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        } 
        
        for (int i = 1; i <= N; i++) {
            for (int j = K; j >= arr[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - arr[i][0]] + arr[i][1]);
                result = Math.max(result, dp[j]);
            }
        }
        System.out.println(dp[K]);
    }
}