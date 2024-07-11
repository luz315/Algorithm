import java.io.*;
import java.util.*;

public class Main{
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int R, C;
    static char arr[][];
    static boolean visit[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visit = new boolean[R][C];

        int WX = -1, WY = -1, SX = -1, SY = -1;  // 초기화

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == '*') {
                    if (WX == -1 && WY == -1) {  // 첫 번째 물 위치 저장
                        WX = i;
                        WY = j;
                    }
                } else if (arr[i][j] == 'S') {
                    SX = i;
                    SY = j;
                }
            }
        }

        bfs(WX, WY, SX, SY);
    }
    
    static void bfs(int wx, int wy, int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        if (wx != -1 && wy != -1) {  // 물의 위치를 큐에 추가
            q.add(new int[]{wx, wy, -1});
            visit[wx][wy] = true;
        }
        if (sx != -1 && sy != -1) {  // 고슴도치의 위치를 큐에 추가
            q.add(new int[]{sx, sy, 0});
            visit[sx][sy] = true;
        }

        while(!q.isEmpty()){
            int[] p = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if (0 <= nx && nx < R && 0 <= ny && ny < C && !visit[nx][ny] && arr[nx][ny] != 'X') {
                    if (arr[nx][ny] == 'D' && p[2] >= 0) {  // 고슴도치가 도착 지점에 도달
                        System.out.println(p[2] + 1);
                        return;
                    }
                    
                    if (p[2] < 0 && arr[nx][ny] == '.') {  // 물 확산
                        arr[nx][ny] = '*';
                        visit[nx][ny] = true;
                        q.add(new int[]{nx, ny, -1});
                    } else if (p[2] >= 0 && arr[nx][ny] == '.') {  // 고슴도치 이동
                        arr[nx][ny] = 'S';
                        visit[nx][ny] = true;
                        q.add(new int[]{nx, ny, p[2] + 1});
                    }
                }
            }
        }
        System.out.println("KAKTUS");  // 모든 가능성을 탐색한 후 탈출하지 못했을 경우 출력
    }
}
