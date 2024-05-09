import java.io.*;
import java.util.*;
public class Main{
    static int arr[][],N;
    static int result = Integer.MAX_VALUE;
    static boolean visit[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N];
        
        for(int i =0; i<N; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0; j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        back(0,0);
        System.out.println(result);
    }
    
    static void back(int choice, int player){
        
        if(choice == N/2){
            int s = 0;
            int l = 0;
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N;j++){
                    if(visit[i]&&visit[j])
                        s += arr[i][j] + arr[j][i];
                    
                    else if(!visit[i]&&!visit[j])
                        l += arr[i][j] + arr[j][i];
                }
            }
            result = Math.min(Math.abs(s-l), result);
            return;
        }
            
        for(int i=player; i<N; i++){
            if(!visit[i]){
                visit[i] = true; // 선택
                back(choice+1, i+1);
                visit[i] = false;
            }    
        }
    }
}