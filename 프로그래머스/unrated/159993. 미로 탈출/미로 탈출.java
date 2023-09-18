import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static String[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0 , -1, 1};
    
    public int solution(String[] maps) {
       
        int[] start = new int[2];
        int[] labor = new int[2];
        
        arr = new String[maps.length][maps[0].length()];
            
        for(int i = 0; i<maps.length; i++) {
            String[] mark = maps[i].split("");
            
            for(int j =0; j<mark.length; j++){
           
                arr[i][j] = mark[j];
                
                if (arr[i][j].equals("S")) {
                    start = new int[]{i, j};
                }
    
                if (arr[i][j].equals("L")) {
                    labor = new int[]{i, j};
                }              
            }
        }
        
        int result = bfs(start, "L");
        int result2 = bfs(labor, "E");
        
        if (result == -1 || result2 == -1){
           return -1;
           
        }
        return result + result2;
    }
    
    
    public int bfs(int start, String target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});
        boolean[][] visit = new boolean[arr.length][arr[0].length];
        
   while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int count = q.peek()[2];
            visit[x][y] = true;
            
            if (arr[x][y].equals(target)) {
                return count;
            }
            
            q.poll();
        
            for(int i = 0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
            
                if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && !visit[nx][ny]) {
                    if (!arr[nx][ny].equals("X")) {
                        visit[nx][ny] = true;
                        q.add(new int[]{nx, ny, count+1});
                    }
                }
            }
        }
        
        return -1;
    }
}