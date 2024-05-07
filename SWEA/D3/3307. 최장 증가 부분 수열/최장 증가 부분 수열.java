import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[] = new int[n];
            int dp[] = new int[n];
            int result = 1;
            
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int end=0; end<n; end++) {
            dp[end] = 1; 
                for(int node=0; node<end; node++) {
                    if(arr[node] < arr[end] && dp[end] < dp[node] + 1) {
                    dp[end] = dp[node] + 1;
                    }
                }
            result = Math.max(result, dp[end]);
            }
            System.out.println("#"+test_case+" "+result);
        }
    }
}



