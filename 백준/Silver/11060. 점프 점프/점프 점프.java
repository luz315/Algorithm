import java.io.*;
import java.util.*;
public class Main{
    static int N,arr[],result[];
    static boolean visit[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visit = new boolean[N];
        result = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        bfs(0);

    }
    
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start]=true;
        
        while(!q.isEmpty()){
            int p = q.poll();
            if(p==(N-1)){
                System.out.println(result[N-1]);
                return;
            }
            for(int i =1; i<=arr[p]; i++){
                int next = p + i;
                if(0<=next&&next<N && !visit[next]){
                    q.add(next);
                    visit[next]=true;
                    result[next]=result[p]+1;
                }
            }
        }
        System.out.println("-1");
    }
}