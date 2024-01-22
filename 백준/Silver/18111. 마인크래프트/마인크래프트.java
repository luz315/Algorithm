import java.util.*;
import java.io.*;
public class Main{
    static int arr[][];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int timelimit = Integer.MAX_VALUE;
    static int N,M,B;
    static int result =0;
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        for(int k=max; k>=min; k--){
            int time = 0;
            int block = B;
            for(int i = 0; i<N;i++){
                for(int j=0; j<M;j++){
                    if(arr[i][j]>k){
                        block+=(arr[i][j]-k);
                        time+=(arr[i][j]-k)*2;
                    }
                    else if(arr[i][j]<k){
                        block-=(k-arr[i][j]);
                        time+=(k-arr[i][j]);
                    }
                }
            }
        
        if(block>=0 && time < timelimit){
            result = k;
            timelimit = time;
        }
        }
        System.out.println(timelimit+" "+result);
        
    }
    
}