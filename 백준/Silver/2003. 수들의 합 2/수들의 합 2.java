import java.io.*;
import java.util.*;
public class Main{
    static int arr[];
    static int N,M;
    static int count=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        
        st = new StringTokenizer(br.readLine());
        for(int i =0; i< N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int j=0; j<N; j++){
            check(j);
        }
        
        System.out.println(count);
    }
    
    public static void check (int n){
        int sum = 0;
        
        for(int i=n;i<N;i++){
            sum += arr[i];
            if(sum==M){
                count++;
                break;
            }else if(sum>M)
                break;
        }
    }
}