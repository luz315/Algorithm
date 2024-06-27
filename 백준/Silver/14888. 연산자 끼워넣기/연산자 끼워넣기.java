import java.io.*;
import java.util.*;
public class Main{
    static int N, arr[], cal[];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int result =0;
        
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr=new int[N];
        cal=new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            cal[i]=Integer.parseInt(st.nextToken());
        }
        
        
        brute(arr[0],1);
        
        System.out.println(max);
        System.out.println(min);
    }
    
    static void brute(int result, int depth){
        if(depth==N){
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }
        
        for(int i=0; i<4; i++){
            if(cal[i]>0){
                cal[i]--;
                
                switch(i){
                    
                    case 0: brute(result+arr[depth], depth+1);
                        break;
                    case 1: brute(result-arr[depth], depth+1);
                        break;
                    case 2: brute(result*arr[depth], depth+1);
                        break;
                    case 3: brute(result/arr[depth], depth+1);
                        break;
                }
                cal[i]++;
            }
        }
        
    }
}