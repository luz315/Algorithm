import java.io.*;
import java.util.*;
public class Main{
    static int M,N;
    static char arr[][];
    static boolean visit[][];
    static int dx[]={-1,1,0,0};
    static int dy[]={0,0,-1,1};
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        int answer = 0;
        
        for(int i=0; i<N; i++){
            arr[i] = br.readLine().toCharArray();
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]=='L'){
                    visit = new boolean[N][M];
                    answer = Math.max(answer,bfs(i,j));
                }
            }
        }
        
        System.out.println(answer);
    }
    
    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y,0});
        visit[x][y]=true;
        int result =0;
        
        while(!q.isEmpty()){
            int p[] = q.poll();
            for(int i=0; i<4;i++){
                int nx = p[0]+dx[i];
                int ny = p[1]+dy[i];
                if(0<=nx&&nx<N && 0<=ny&&ny<M && arr[nx][ny]=='L' && !visit[nx][ny]){
                    q.add(new int[]{nx,ny,p[2]+1});
                    visit[nx][ny]=true;
                    result = Math.max(result,p[2]+1);
                }
            }
        }
        
        return result;
    }
}