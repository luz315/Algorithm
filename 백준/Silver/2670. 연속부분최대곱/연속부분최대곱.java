import java.io.*;
import java.util.*;
public class Main{
    static int n;
    static double result = Double.MIN_VALUE;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        double dp[] = new double[n];
        
        double result = Double.MIN_VALUE;
        
        for(int i=1; i<n; i++){
            dp[i] = Double.parseDouble(br.readLine());
            dp[i] = Math.max(dp[i],dp[i]*dp[i-1]);
            result = Math.max(dp[i], result);
        }
        
        System.out.printf("%.3f\n",result);
    }
}