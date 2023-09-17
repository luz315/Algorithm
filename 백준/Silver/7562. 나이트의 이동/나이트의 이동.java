import java.io.*;
import java.util.*;
public class Main{
    static int T,size,x,y,x1,y1;
    static int arr[][];
    static boolean visit[][];
    static int result=0;
    static int dx[] = {1, 2, 2, 1, -1, -2, -2, -1 };
    static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2 };
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        T=Integer.parseInt(br.readLine());
       
   
       while(T-->0){
            size=Integer.parseInt(br.readLine());
            arr=new int[size][size];
            visit= new boolean[size][size];
            st= new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            
            st= new StringTokenizer(br.readLine());
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            
            bfs();
        } 
    }
    
    static void bfs(){
        q.add(new int[]{x,y});
        visit[x][y]= true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nx=now[0];
            int ny=now[1];
            
            for(int i =0; i<8;i++){
                int ox = nx+dx[i];
                int oy = ny+dy[i];
                
                if(ox>=0 && oy>=0 && ox < size && oy <size){
                    if(!visit[ox][oy]){
                        q.add(new int[]{ox,oy});
                        arr[ox][oy] = arr[nx][ny] +1;
                        visit[ox][oy] =true;
                    }
                }
            }
        }
         System.out.println(arr[x1][y1]); 
        
    }
}