import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
       
        while((s=br.readLine())!=null){
        int arr[] = new int[4];
            for(int i = 0; i<s.length();i++){
                char c = s.charAt(i);
                if('a'<=c && c<='z'){
                   arr[0]++;
                }
                else if('A'<=c && c<='Z'){
                    arr[1]++;
                }
                else if('0'<=c && c<='9'){
                    arr[2]++;
                }
                else{
                    arr[3]++;
                }
            }
             System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
        }  
    }
}