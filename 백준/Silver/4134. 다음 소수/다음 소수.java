import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i =0; i< T; i++){
            long N = Long.parseLong(br.readLine());
            if (N <= 1) N = 2;  
            while(true){
                int count = 0;
                for(int j = 2; j<=Math.sqrt(N); j++){
                    if(N%j==0){
                        count++;
                        break;
                    }
                }
                
                if(count == 0){
                    System.out.println(N);
                    break;
                }
            N++;
            }
        }
    }
}