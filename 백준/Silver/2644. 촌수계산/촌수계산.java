import java.io.*;
import java.util.*;
public class Main{
    static int arr[][];
    static boolean visit[];
    static int n, r1, r2, m;
    static int result = -1;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        
        m = Integer.parseInt(br.readLine());
        
        arr = new int[n+1][n+1];
        visit = new boolean[n+1];
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y]=arr[y][x]=1;
        }
        DFS(r1,0);
        
        System.out.print(result);   
    }
    public static void DFS(int now, int count){
        visit[now] = true;
        
        if(now==r2){
            result=count;
            return;
        }
        
        for(int i =1; i<=n; i++){
            if(arr[now][i] == 1 && visit[i]==false){
                DFS(i, count+1);
                
            }
        }
    }
}