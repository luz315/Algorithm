import java.io.*;
import java.util.*;
public class Main{
    static int[][] arr;
    static boolean[] visit;
    static int x, y, N;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        arr = new int[N+1][N+1];
        visit = new boolean[N+1];
        
        for(int i =0; i<M; i++){
            
            st= new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }
        
        DFS(V);
        System.out.println();
         visit = new boolean[N + 1];
        BFS(V);
    }
    
    public static void DFS(int node){
        visit[node]=true;
        System.out.print(node + " ");
        for(int i =1; i< N+1; i++){
            if(arr[node][i]==1 && visit[i] == false){
                DFS(i);
            }
        }
    }
    
    public static void BFS(int node){
        q.add(node);
        visit[node]=true;

        while(!q.isEmpty()) {
            
            node= q.poll();
			
		
            System.out.print(node + " ");
            
            for(int i = 1; i<N+1; i++){
                if(arr[node][i] == 1 && visit[i]==false) {
					q.add(i);
					visit[i] = true;
                }
            }
        }
    }
}