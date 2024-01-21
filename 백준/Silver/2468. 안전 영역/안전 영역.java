import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static int limit = 0; 
    static int dx[] ={0,0,1,-1};
    static int dy[] ={1,-1,0,0};
    static int map[][];
    static boolean visit[][];
    
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                limit = Math.max(limit,map[i][j]);
            }
        }
        int result = 0;
        for(int h = 0; h<=limit; h++){
            visit = new boolean[N][N];
            int count = 0;
            for(int i =0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visit[i][j] && map[i][j]>h){
                        dfs(i, j, h);
                        count++;
                    }
                }
            }
            result = Math.max(result,count);
        }
        System.out.println(result);
        
    }
    public static void dfs(int x, int y, int height){
        visit[x][y] = true;
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0<=nx&&nx<N && 0<=ny&&ny<N && map[nx][ny]>height && !visit[nx][ny]){
                dfs(nx, ny, height);
            }   
        }
    }
}