import java.io.*;
import java.util.*;
public class Main{
    static int dx[]={0,0,1,-1};
    static int dy[]={1,-1,0,0};
    static boolean visit[][];
    static int N;
    static char arr[][];
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        
        visit = new boolean[N][N];
        for(int i=0;i<N;i++){
            arr[i] = br.readLine().toCharArray();
        }
        
        int normal=0;
        
        for(int i =0; i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j]){
                    bfs(i,j);
                    normal++;
                }
            }
        }
    
    
        visit = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]=='G'){
                    arr[i][j]='R';
                }
            }
        }
        
       
        int blind=0;
        for(int i =0; i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j]){
                    bfs(i,j);
                    blind ++;
                }
            }
        }
        
        System.out.println(normal);
        System.out.println(blind);
    }
    
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visit[x][y]=true;
        char color = arr[x][y];
        
        while(!q.isEmpty()){
            int p[] = q.poll();
            for(int i =0; i<4;i++){
                int nx = p[0]+dx[i];
                int ny = p[1]+dy[i];
                if(0<=nx&&nx<N && 0<=ny&&ny<N && !visit[nx][ny]){
                    if(arr[nx][ny]==color){
                        visit[nx][ny]=true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}