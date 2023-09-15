import java.io.*;
import java.awt.Point;
import java.util.*;
public class Main{
    static int w, h;
    static int arr[][];
    static boolean visit[][];
    
    static int dx[] = {0, 0, -1 ,1, -1, 1, -1, 1};
    static int dy[] = {-1, 1, 0, 0, 1, 1, -1, -1};
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
           st=new StringTokenizer(br.readLine());
           w =Integer.parseInt(st.nextToken());
           h =Integer.parseInt(st.nextToken());
           
           if(w==0 && h==0){ 
               break;
           }
        
           arr= new int[h][w];
           visit= new boolean[h][w];
        
           for(int i =0; i<h; i++){
               st = new StringTokenizer(br.readLine());
               for(int j=0; j<w; j++){
                    arr[i][j]= Integer.parseInt(st.nextToken());
               }
           }
            int count=0;

            for(int i =0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(visit[i][j] == false && arr[i][j]==1){
                        bfs(i,j);
                        count ++;
                    }
                }
            }
            System.out.println(count);
        }
    }  
        
    public static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visit[x][y]=true;
            
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0;i<8;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >=0 && ny >=0 && nx <h && ny < w){
                    if(visit[nx][ny] == false && arr[nx][ny] == 1){
                        q.add(new Point(nx,ny));
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }
}
