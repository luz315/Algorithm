import java.io.*;
import java.util.*;
public class Main{
    static int dx[]={0,0,0,0,1,-1};
    static int dy[]={1,-1,0,0,0,0};
    static int dz[]={0,0,1,-1,0,0};
    static int M,N,H,arr[][][];
    static int result =0;
    static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        arr = new int[H][N][M];
        
        
        for(int i=0;i<H;i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    
                    if(arr[i][j][k]==1){
                        q.add(new int[]{i,j,k,0});
                    }
                }
            }
        }
        bfs();
        
        for(int i=0;i<H;i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(arr[i][j][k]==0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(result);
    }
    
    static void bfs(){
        while(!q.isEmpty()){
            int p[] = q.poll();
            for(int i=0; i<6; i++){
                int nz = p[0]+dz[i];
                int nx = p[1]+dx[i];
                int ny = p[2]+dy[i];
                
                if(0<=nz&&nz<H && 0<=nx&&nx<N && 0<=ny&&ny<M){
                    if(arr[nz][nx][ny]==0){
                        q.add(new int[] {nz,nx,ny,p[3]+1});
                        arr[nz][nx][ny] = 1;
                        result = p[3]+1;
                    }
                }
            }            
        }
    }
}