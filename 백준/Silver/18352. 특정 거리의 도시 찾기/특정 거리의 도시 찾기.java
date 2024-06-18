import java.io.*;
import java.util.*;
public class Main{
    static int N,M,K,X,start,end,count[];
    static ArrayList<Integer> arr[];
    static boolean visit[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        count = new int[N+1];
        visit = new boolean[N+1];
        
        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
            count[i]= -1;
        }
        
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
        }
        
        bfs();
        
        boolean found = false;
        for(int i=1;i<=N;i++){
            if(count[i]==K){
                System.out.println(i);
                found = true;
            }
        }
        if(!found){
            System.out.println("-1");
        }
    }
    
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(X);
        visit[X]=true;
        
        count[X]=0;
        
        while(!q.isEmpty()){
            int p = q.poll();
            for(int i=0; i<arr[p].size(); i++){
                for(int next: arr[p]){
                    if(!visit[next]){
                        q.add(next);
                        visit[next]=true;
                        count[next]=count[p]+1;
                    }
                }
            }
        }
    }
}