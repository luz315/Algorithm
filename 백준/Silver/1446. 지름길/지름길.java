import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int road = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int arr[][] = new int[road][3];

        for(int i=0;i<road;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dp[] = new int[goal+1];

        for(int i=0;i<=goal;i++){
            dp[i] = i;
        }

        for(int i=1;i<=goal;i++){
            dp[i] = Math.min(dp[i],dp[i-1]+1);
            for(int j=0;j<road;j++){
                if(arr[j][1]==i){
                    dp[i] = Math.min(dp[i], dp[arr[j][0]]+arr[j][2]);
                }

            }
        }

        System.out.println(dp[goal]);

    }
}
