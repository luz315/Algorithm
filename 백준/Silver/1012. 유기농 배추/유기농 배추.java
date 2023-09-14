import java.util.*;
import java.io.*;

public class Main {
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	static int arr[][];
	static boolean visit[][];

	static int now_x, now_y;
	static int M, N, K;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new int[M][N];
			visit = new boolean[M][N];

			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}

			count = 0;
			for(int j=0; j<M; j++) {
				for(int k=0; k<N; k++) {

					if(arr[j][k] == 1 && visit[j][k] == false) {
						count++;
						DFS(j, k);
					}
				}
			}
			sb.append(count).append('\n');
		}

		System.out.println(sb);
	} // End Main
	
	public static void DFS(int x, int y) {
		visit[x][y] = true;

		for(int i=0; i<4; i++) {
			now_x = x + dirX[i];
			now_y = y + dirY[i];

			if(Range_check() && visit[now_x][now_y] == false && arr[now_x][now_y] == 1) {
				DFS(now_x, now_y);
			}

		}
	}

	static boolean Range_check() {
		return (now_x < M && now_x >= 0 && now_y < N && now_y >= 0);
	}
}