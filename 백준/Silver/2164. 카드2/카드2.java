import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N]; 
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            q.add(i);
        }
      
        if(q.size()==2){
            q.poll();
            System.out.println(q.peek());
        }
        else{
            while(!q.isEmpty()){ //1234  / 342  / 24 : 12
               if(q.size()==1){
                   System.out.println(q.poll());
                   return;
               }else{
                   q.poll(); //234  / 42  / 4  / 2
                   int p = q.peek(); //2  / 4
                   q.poll(); //34  / 2
                   q.add(p); //342 / 24
               }
                
            }
        }
        
    }
}