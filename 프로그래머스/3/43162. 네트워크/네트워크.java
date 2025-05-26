import java.util.*;

class Solution {
    static boolean visit[];
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                bfs(i,computers);
                count++;
            }
        }
        return count;
    }
    
    static void bfs(int start, int[][]computers){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start]=true;
        
        while(!q.isEmpty()){
            int p = q.poll();
            for(int i=0;i<computers.length;i++){
                if(computers[p][i]==1&&!visit[i]){
                        visit[i]=true;
                        q.add(i);
                }
            }
        }
    }
}