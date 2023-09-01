import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int T = Integer.parseInt(br.readLine());
         Deque<Integer> que = new LinkedList<>();
      
        while(T-->0){
           String s = br.readLine();
         if(s.contains("push")){
               String spt[] = s.split(" ");
				que.offer(Integer.parseInt(spt[1]));
           }
            switch(s){
                case "pop":
                if(que.isEmpty())
                      bw.write(-1+"\n");
                else
                       bw.write(que.poll()+"\n");
                break;
                
                case "size":
                    bw.write(que.size()+"\n");
                break;
                
                case "empty":
                if(que.isEmpty())
                    bw.write(1+"\n");
                else 
                    bw.write(0+"\n");
                break;
                
                case "front":
                if(que.isEmpty())
                    bw.write(-1+"\n");
                else 
                     bw.write(que.peek()+"\n");
                break;
                
                case "back":
                if(que.isEmpty())
                    bw.write(-1+"\n");
                else
                     bw.write(que.peekLast()+"\n");
                break;
            }
        }
        bw.flush();
    }
}