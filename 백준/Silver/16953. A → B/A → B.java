import java.io.*;
import java.util.*;
public class Main{
    static long a,b;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        
        System.out.println(bfs());

    }
    static int bfs(){
        Queue<Long> q = new LinkedList<>();
        q.add(a);
        int count =0;
        
        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int i=0;i<size;i++){
                long p = q.poll();
                if(p==b)
                    return count;
                if(p>b)
                    continue;
                q.add(p*2);
                q.add(p*10+1);
            }
        }
        return -1;
    }
}