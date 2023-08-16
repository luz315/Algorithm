import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String spt[] = new String[s.length()];
        
        for(int i=0; i<s.length(); i++){
            spt[i] = s.substring(i,s.length()); 
        }
        
        Arrays.sort(spt);
        
        for(String result:spt)
            System.out.println(result);
        
    }
}