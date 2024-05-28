import java.io.*;
import java.util.*;
public class Main{
    static int N, arr[][];
    static int limit = 0;
    static int result = 0;
    static boolean visit[][];
    static int dx[]={0,0,1,-1};
    static int dy[]={1,-1,0,0};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                limit = Math.max(limit,arr[i][j]);
            }
        }
        for(int d = 0; d<limit;d++){
            visit = new boolean[N][N];
            int count = 0;
            for(int i=0;i<N;i++){
                for(int j=0; j<N;j++){
                    if(!visit[i][j]&&arr[i][j]>d){
                        count++;
                        back(i,j,d);
                    }
                }
            }
            result = Math.max(count, result);
        }
        System.out.println(result);
    }
    
    public static void back(int x, int y, int depth){
        visit[x][y]=true;
        for(int i=0; i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx&&nx<N && 0<=ny&&ny<N && !visit[nx][ny] && arr[nx][ny]>depth){
                
                back(nx, ny, depth);
                
            }
        }        
    }
}