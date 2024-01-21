import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static String s;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static char arr[][];
    static boolean visit[][];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N=Integer.parseInt(br.readLine());
        arr= new char[N][N];
        visit= new boolean[N][N];
        int Acount =0;
        int Bcount=0;
      
        for(int i =0; i<N; i++){
            s=br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j]=s.charAt(j);
            }
        }
        
        for(int i =0; i<N; i++){
            for(int j =0; j<N;j++){
                if(!visit[i][j]){
                    dfs(i,j);
                    Acount++;
                }
            }
        }
        
        for(int i=0; i<N;i++){
            for(int j =0; j<N;j++){
                if(arr[i][j]=='G'){
                    arr[i][j]='R';
                }
            }
        }
        
        visit= new boolean[N][N];
        
        for(int i =0; i<N; i++){
            for(int j =0; j<N;j++){
                if(!visit[i][j]){
                    dfs(i,j);
                    Bcount++;
                }
            }
        }
        
        System.out.println(Acount+" "+Bcount);
    }
    
    public static void dfs(int x, int y){
        visit[x][y] = true;
        char color = arr[x][y];
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx&&nx<N && 0<=ny&&ny<N && !visit[nx][ny]){
                if(arr[nx][ny]==color){
                    dfs(nx,ny);
                }
            }
        }
    }
}