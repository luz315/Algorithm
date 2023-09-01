import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
       
        
        for(int i =0; i<T;i++){
             StringTokenizer st = new StringTokenizer(br.readLine());
        
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int G = gcd(A,B);
            int L = A*B/G;
            System.out.println(L);
        }
    }
    public static int gcd(int A, int B){
        if(B==0)
            return A;
        else
            return gcd(B,A%B);
    }
}