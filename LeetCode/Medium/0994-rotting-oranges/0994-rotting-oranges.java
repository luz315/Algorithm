class Solution {
    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        return countMinute(q,grid,fresh);
    }

    private int countMinute(Queue<int[]> q, int[][]grid, int fresh){
        int minute = 0;

        while(!q.isEmpty()){
            int[] p = q.poll();
            minute = p[2];
            for(int i=0;i<4;i++){
                int nx = p[0]+dx[i];
                int ny = p[1]+dy[i];
            
                if(0>nx || nx>=grid.length || 0>ny || ny>=grid[0].length) continue;

                if(grid[nx][ny]==1){
                    grid[nx][ny]=2;
                    q.offer(new int[]{nx,ny,p[2]+1});
                    fresh--;
                }
            }
        }
        return fresh==0?minute:-1;
    }
}