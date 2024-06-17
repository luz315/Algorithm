import java.io.*;
import java.util.*;
public class Main{
    static int F, start, end, up, down, count,arr[];
    static boolean visit[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());
        count =0;
        visit = new boolean[F+1];
        arr = new int[F+1];
      
        if(bfs()==-1){
            System.out.println("use the stairs");
        }
        else
            System.out.println(arr[end]);
       
    }
    
    static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start]=true;
        
        int[] cal = {up, -down}; 
        
        while(!q.isEmpty()){
            int p = q.poll();
            if(p==end){
                return arr[p];
            }
            for(int i=0; i<2;i++){
                int np = p + cal[i];
                if(0<np&&np<=F&&!visit[np]){
                    visit[np] = true;
                    q.add(np);
                    arr[np]=arr[p]+1;
                }
            }
        }
        return -1;
    }
}