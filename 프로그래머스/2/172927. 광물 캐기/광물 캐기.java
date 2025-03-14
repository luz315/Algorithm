import java.util.*;
class Solution {
    static int result = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        dfs(picks, minerals, 0, 0);
        return result;
    }
    
    static void dfs(int picks[], String minerals[], int depth, int stress){
        if(depth==minerals.length || Arrays.stream(picks).sum()==0){
            result = Math.min(result,stress);
            return;
        }
        for(int i=0;i<3;i++){
            if(picks[i]>0){
                picks[i]--;
                int count = stress;
                for(int j=depth; j<Math.min(depth+5, minerals.length); j++){
                    switch(i){
                        case 0:
                            count++;
                            break;
                        case 1:
                            if(minerals[j].equals("diamond"))
                                count+=5;
                            else
                                count++;
                            break;
                        case 2:
                            if(minerals[j].equals("diamond"))
                                count+=25;
                            else if(minerals[j].equals("iron"))
                                count+=5;
                            else
                                count++;
                            break;
                    }
                }
                dfs(picks, minerals, depth+5, count);
                picks[i]++;
            }
        }
    }
}