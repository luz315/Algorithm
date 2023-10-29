import java.util.*;
import java.io.*;
import java.math.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        BigInteger bi = new BigInteger("2");
        System.out.println(bi.pow(n).subtract(new BigInteger("1")));
        
        if (n <= 20)
            F(n, 1, 2, 3);
    }
    
    public static void F(int n, int A, int B, int C){
        
        if(n==1){
            System.out.println(A+" "+C);
            return;
        }
        F(n-1, A, C, B);
        System.out.println(A+" "+C);
        F(n-1, B, A, C);
        
        return;
    }
}