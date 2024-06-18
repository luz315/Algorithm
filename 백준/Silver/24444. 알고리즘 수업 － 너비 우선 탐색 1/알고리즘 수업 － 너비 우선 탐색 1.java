import java.io.*;
import java.util.*;
public class Main{
    static boolean visit[];
    static int N,M,R,u,v,result[];
    static ArrayList<Integer> arr[];
    static int count =1;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        visit = new boolean[N+1];
        result = new int[N+1];
        
        for(int i=1; i<=N; i++){
            arr[i]=new ArrayList<>();
        }
        
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        
        for(int i=1; i<=N; i++){
            Collections.sort(arr[i]);
        }
       
        bfs(R);
        
        for(int i=1; i<=N; i++){
            System.out.println(result[i]);
        }
    }
    
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start]=true;
        result[start]=count++;
        
        while(!q.isEmpty()){
            int p = q.poll();
            for(int i=0; i<arr[p].size();i++){
                int next = arr[p].get(i);
                if(!visit[next]){
                    q.add(next);
                    visit[next]=true;
                    result[next]=count++;
                }
            }
        }
    }
}