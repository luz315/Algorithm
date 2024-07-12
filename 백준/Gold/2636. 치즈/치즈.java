import java.io.*;
import java.util.*;
public class Main{
    static int N,M,arr[][],cheese;
    static int time=0;
    static boolean visit[][];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0}; 
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        
        cheese =0;
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    cheese++;
                }
            }
        }
        
        int result = 0;
        while(cheese!=0){
            visit = new boolean[N][M];
            result = cheese;
            bfs();
            time++;
        }
        
        System.out.println(time);
        System.out.println(result);
        
    }
    
    static void bfs(){
        q.add(new int[]{0,0});
        visit[0][0] = true;
        while(!q.isEmpty()){
            int p[] = q.poll();
            
            for(int i=0;i<4;i++){
                int nx = p[0]+dx[i];
                int ny = p[1]+dy[i];
                if(0<=nx&&nx<N && 0<=ny&&ny<M && !visit[nx][ny]){
                    visit[nx][ny]=true;
                    
                    if(arr[nx][ny]==1){
                        arr[nx][ny] = 0;
                        cheese--;
                    }
                    else if(arr[nx][ny]==0){
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}