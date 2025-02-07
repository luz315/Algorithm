import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int arr[][] = new int[N][4];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());            
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (a, b) -> {
           if (a[1] != b[1]) return Integer.compare(b[1], a[1]); 
           if (a[2] != b[2]) return Integer.compare(b[2], a[2]);
           return Integer.compare(b[3], a[3]); 
        });
        
        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i][0] == K) { 
                for (int j = 0; j < i; j++) {  
                    if (arr[i][1] == arr[j][1] && arr[i][2] == arr[j][2] && arr[i][3] == arr[j][3]) {
                        rank = j + 1; 
                        break;
                    }
                }
                System.out.println(rank);
                return;
            }
            rank++;
        }
    }
}