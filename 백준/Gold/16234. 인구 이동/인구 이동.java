import java.io.*;
import java.util.*;
public class Main{
    static int N,L,R,arr[][];
    static boolean visit[][];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int movecount = 0;
        while(true){
            boolean move = false;
            visit = new boolean[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visit[i][j]&&bfs(i,j)){
                        move=true;
                    }
                }
            }
            if(!move){
                break;
            }
            movecount++;
        }
        System.out.println(movecount);
    }
    
    static boolean bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visit[x][y]=true;
        int sum = arr[x][y];
        int count = 1;
        
        List<int[]> node = new ArrayList<>();
        node.add(new int[]{x,y});
       
        while(!q.isEmpty()){
            int p[] = q.poll();
            for(int i=0; i<4;i++){
                int nx = p[0] + dx[i], ny = p[1] + dy[i];
                if(0<=nx&&nx<N && 0<=ny&&ny<N && !visit[nx][ny]){
                    int diff = Math.abs(arr[p[0]][p[1]]-arr[nx][ny]);
                    if(L<=diff&&diff<=R){
                        visit[nx][ny]=true;
                        q.add(new int[]{nx,ny});
                        sum += arr[nx][ny];
                        count++;
                        node.add(new int[]{nx,ny});
                    }
                }
            }
        }
        
        if(count>1){
            int avg = sum/count;
            for(int[] n: node){
                arr[n[0]][n[1]] = avg;
            }
            return true;
        }
        return false;
    }
}