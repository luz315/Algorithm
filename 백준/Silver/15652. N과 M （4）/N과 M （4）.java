import java.io.*;
import java.util.*;
public class Main{
    static int N,M,arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr = new int[M];
        
        back(0,1);
        System.out.println(sb);
    }
    
    public static void back(int depth, int next){
        if(depth==M){
            for(int i : arr){
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }
        
        for(int j =next; j<=N; j++){
            arr[depth]=j;
            back(depth+1, j);
        }
    }
}