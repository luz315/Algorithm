import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N + 1];
        int INF = Integer.MAX_VALUE / 2;

        Arrays.fill(dp, INF);

        if (N >= 3) dp[3] = 1;
        if (N >= 5) dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            if (dp[i - 3] != INF || dp[i - 5] != INF) {  // 유효한 값을 가지고 있을 때만 갱신
                dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
            }
        }

        System.out.println(dp[N] == INF ? -1 : dp[N]);
    }
}
