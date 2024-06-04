import java.io.*;
import java.util.*;
import java.awt.Point;
public class Main{
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static int arr[][],N,M;
    static boolean visit[][];
    static int count = 1;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];
        
        for(int i =0; i<N; i++){
            String s = br.readLine();
            for(int j =0; j<M; j++){
                arr[i][j] = s.charAt(j)- '0';
            }
        }
        
        bfs(0,0);
        System.out.println(arr[N-1][M-1]);
    }
    
    static void bfs(int x, int y){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x,y));
        visit[x][y]=true;
        
        while(!que.isEmpty()){
            Point p = que.poll();
            for(int i =0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<M && !visit[nx][ny] && arr[nx][ny]>0){
                    que.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                    arr[nx][ny] = arr[p.x][p.y] + 1;
                }
           }
        }
    }
}