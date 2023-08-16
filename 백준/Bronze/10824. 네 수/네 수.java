import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String spt[] = br.readLine().split(" ");
        
        long a = Long.parseLong(spt[0]+spt[1]);
        long b = Long.parseLong(spt[2]+spt[3]);
        
        System.out.println(a+b);
    }
}