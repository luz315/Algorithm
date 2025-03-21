import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2)->{
            return o1[1] - o2[1];
        });
        int count =1;
        int now = routes[0][1];
        for(int i=1;i<routes.length;i++){
            if(routes[i][0]>now){
                now = routes[i][1];
                count++;
            }
        }
        return count;
    }
}