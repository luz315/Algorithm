import java.io.*;
import java.util.*;
import java.awt.*;
public class Main{
    static int arr[][];
    static int M,N;
    static int value = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st= new StringTokenizer(br.readLine());
        
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
      
        arr = new int[N][M];
 
        for(int i = 0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                    
                    if(arr[i][j]==1) {
                        q.add(new Point(i,j)); 
                    }
            }
        }
        System.out.println(bfs());
    }
    
    public static int bfs(){
        while(!q.isEmpty()){
            Point p = q.poll();
             
            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(arr[nx][ny]==0){
                        q.add(new Point(nx,ny));
                        arr[nx][ny] = arr[p.x][p.y] + 1;
                    }
                }
            }
        }
            
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <M; j++) {
                    if(arr[i][j] == 0) {
                        return -1;
                    }
                    value = Math.max(value, arr[i][j]); 
            }
        }
       if(value == 1)
    		return 0;
    	else
    		return value - 1;
        }    
}