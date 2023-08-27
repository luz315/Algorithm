import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int result = 0;
        int now = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1]-o2[1]);
        for(int i=0; i<targets.length; i++) {
        	if(targets[i][0] >= now) {
        		now = targets[i][1];
        		result++;
        	}
        }
        return result;
    }
}