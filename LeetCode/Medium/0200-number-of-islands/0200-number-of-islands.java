class Solution {
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,1,-1,0};
    public int numIslands(char[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i =0; i< grid.length;i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'&&!visit[i][j]){
                    bfs(grid,i,j,visit);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int x,int y, boolean[][] visit){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visit[x][y] = true;

        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int i = 0;i<4;i++){
                int nx = p[0]+dx[i];
                int ny = p[1]+dy[i];

                if(0<=nx && nx <grid.length && 0<= ny && ny < grid[0].length && !visit[nx][ny] && grid[nx][ny]=='1'){
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }
}