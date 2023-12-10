import java.util.*;
import java.io.*;

public class Main{
static int arr[], N, M;
static boolean visit[];
static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];
      
        back(0);
        System.out.println(sb);    
    }
    
    public static void back(int end){
        if(end == M){
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
            
        }
        
        for(int i = 0; i< N;i++){
           if(!visit[i]){
               visit[i]=true;
                arr[end] = i + 1;
                back(end + 1);
                visit[i] = false; 
           }
        }
    }
}