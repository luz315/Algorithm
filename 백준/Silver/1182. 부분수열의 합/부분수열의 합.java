import java.io.*;
import java.util.*;
public class Main{
    static int N,S,arr[];
    static int count=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        
        
        dfs(0,0);
        
        if(S==0){
            System.out.println(count-1);
        }
        else{
            System.out.println(count);
        }
    }
    static void dfs(int start, int sum){
        if(start==N){
            if(sum==S){
                count++;
            }
            return;
        }
        
        int next = start+1;
        
        dfs(next,sum+arr[start]);
        dfs(next,sum);
    }
}