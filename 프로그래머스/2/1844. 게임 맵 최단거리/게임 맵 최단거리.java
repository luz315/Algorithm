import java.util.*;
class Solution {
    static boolean visit[][];
    static int count=-1;
    static int dx[]={0,0,1,-1};
    static int dy[]={1,-1,0,0};
    public int solution(int[][] maps) {
        visit = new boolean[maps.length][maps[0].length];
        return bfs(0,0,maps);
    }
    static int bfs(int x, int y, int[][] arr){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y,1});
        visit[x][y]=true;
        
        while(!q.isEmpty()){
            int p[] = q.poll();
            if (p[0] == arr.length - 1 && p[1] == arr[0].length - 1) {
                return p[2]; 
            }
            for(int i=0;i<4;i++){
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if(0<=nx&&nx<arr.length && 0<=ny&&ny<arr[0].length){
                    if(!visit[nx][ny]&&arr[nx][ny]==1){
                        visit[nx][ny] = true;
                        q.add(new int[]{nx,ny,p[2]+1});
                    }
                }
            }
        }
        return -1;
    }
}