import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int max = 0;
    static char[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visit = new boolean[26]; // A-Z 알파벳 방문 여부를 체크

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 0); // 초기 count를 0으로 시작
        System.out.println(max);
    }

    static void dfs(int x, int y, int count) {
        int index = arr[x][y] - 'A';
        if (visit[index]) {
            max = Math.max(max, count);
            return;
        }

        visit[index] = true;
        max = Math.max(max, count + 1); // 현재 위치를 포함하여 count를 증가

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                dfs(nx, ny, count + 1);
            }
        }
        visit[index] = false; // 백트래킹
    }
}
