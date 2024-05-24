import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long N = Long.parseLong(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long H = Long.parseLong(st.nextToken());
        
        double start=0;
        double end=Math.max(L,Math.max(W,H));
        
        
        for(int i=0;i<10000;i++){
            double mid = (start+end)/2;
            
            if((long)(L/mid)*(long)(W/mid)*(long)(H/mid)>=N){
                start = mid;
            }
            
            else
                end = mid;
        }
        
        System.out.println(start);
    }
}