import java.io.*;
import java.util.*;
public class Main{
    static int N,arr[];
    static boolean visit[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visit = new boolean[N];
        
        back(0);
    }
    
    public static void back(int depth){
        if(depth==N){
            for(int i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        
        for(int i = 0; i<N;i++){
            if(!visit[i]){
                visit[i]=true;
                arr[depth]=i+1;
                back(depth+1);
                visit[i]=false;
            }
        }
    }
}