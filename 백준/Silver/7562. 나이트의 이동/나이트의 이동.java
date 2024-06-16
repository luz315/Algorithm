import java.io.*;
import java.util.*;
import java.awt.*;
public class Main{
    static int dx[] = {1, 2, 2, 1, -1, -2, -2, -1 };
    static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2 };
    static int count,I,A1,A2,B1,B2;
    static boolean visit[][];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0){
            I = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            A1 = Integer.parseInt(st.nextToken());
            B1 = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            A2 = Integer.parseInt(st.nextToken());
            B2 = Integer.parseInt(st.nextToken());
            
            visit = new boolean[I][I];
        
            System.out.println(bfs(A1,B1));
        }
        
    }
    
    static int bfs(int x, int y){
       
        Queue <Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visit[x][y]=true;
        count =0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0;j<size;j++){
                 Point p = q.poll();
                if(p.x==A2&&p.y==B2){
                    return count;
                }
                for(int i=0; i<8;i++){
                    int nextx=p.x+dx[i];
                    int nexty=p.y+dy[i];
                    if(0<=nextx&&nextx<I && 0<=nexty&&nexty<I && !visit[nextx][nexty]){
                        q.add(new Point(nextx,nexty));
                        visit[nextx][nexty]=true;
                    }
                }
            }
            count++;
        }
        return count;
    }
}
    
    