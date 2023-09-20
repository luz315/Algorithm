import java.io.*;
import java.util.*;
public class Main{
    static int x,y,N;
    static boolean visit[];
    static int parent[];
    static ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
      
        for(int i=0; i<=N;i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i =0; i<N-1; i++){
            st= new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr.get(x).add(y);
            arr.get(y).add(x);
        }
        visit = new boolean[N+1];
        parent = new int[N+1];
        
        DFS(1);
        
        for(int i = 2;i<parent.length; i++){
            System.out.println(parent[i]);
            
        }
    
    }
    
    public static void DFS(int a){
        visit[a] = true;
       
         for (int i : arr.get(a)) {
            if (!visit[i]) {
                DFS(i);
                parent[i]=a;
            }
        }
             
    }
}