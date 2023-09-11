import java.util.*;
import java.io.*;

public class Main {
	static int arr[][];
	static boolean visit[];

	static int N, M;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); 
		M = Integer.parseInt(br.readLine()); 

		visit = new boolean[N+1];
		arr	= new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
            arr[y][x] = 1;
			
		}

		DFS(1);

		System.out.println(result);
	} 

	static void DFS(int node) {
		visit[node] = true;

		for(int i=1; i<N+1; i++) {

			if(arr[node][i] == 1 && visit[i] == false) {
				DFS(i);
				result++;
			}
		}

	} 
} 