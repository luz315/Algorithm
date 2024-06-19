import java.io.*;
import java.util.*;
import java.awt.*;
public class Main{
    static int dx[] ={0,0,1,-1};
    static int dy[] ={1,-1,0,0};
    static int N,M,arr[][];
    static boolean visit[][][];
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        arr= new int[N][M];
        visit = new boolean[N][M][2];
        
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }
        bfs(0,0);
        
    }
    static void bfs(int x, int y){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{x,y,1,0});
        visit[x][y][0] =true;
        
        while(!q.isEmpty()){
            int p[] = q.poll();
            if(p[0]==N-1 && p[1]==M-1){
                System.out.println(p[2]);
                return;
            }
            for(int i=0;i<4;i++){
                int nx =p[0]+dx[i];
                int ny =p[1]+dy[i];
                if(0<=nx&&nx<N && 0<=ny&&ny<M && !visit[nx][ny][p[3]]){
                    if(arr[nx][ny]==0){
                        q.add(new int[]{nx,ny,p[2]+1,p[3]});
                        visit[nx][ny][p[3]]=true;
                    }
                    else if(arr[nx][ny]==1 && p[3]==0&& !visit[nx][ny][1]){
                        q.add(new int[]{nx,ny,p[2]+1,1});
                        visit[nx][ny][1]=true;
                    }
                }
            }
        }
        System.out.println("-1");
    }
}