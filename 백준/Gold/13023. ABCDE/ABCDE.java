import java.io.*;
import java.util.*;
public class Main{
    static int N,M;
    static boolean visit[],check;
    static List<Integer>[] friend;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        friend = new ArrayList[N];
        for(int i=0;i<N;i++){
            friend[i]=new ArrayList<>();
        }
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a].add(b);
            friend[b].add(a);
        }
        
        visit = new boolean[N];
        for(int i=0;i<N;i++){
            if(!check){
                visit[i]=true;  
                back(i,0);
                visit[i]=false;
            }
        }
        System.out.println(check?1:0);
    }
    
    static void back(int node, int depth){
        if(depth==4){
            check = true;
            return;
        }
        
        for(int next:friend[node]){
            if(!visit[next]){
                visit[next]=true;
                back(next, depth+1);
                visit[next]=false;
            }
        }
    }
}