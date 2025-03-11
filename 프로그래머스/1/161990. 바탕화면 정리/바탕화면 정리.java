import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {   
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;   
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int answer[] = new int[4];
        
        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[0].length();j++){
                if(wallpaper[i].charAt(j)==('#')){ 
                    minX = Math.min(i,minX); 
                    maxX = Math.max(i,maxX); 
                    minY = Math.min(j,minY); 
                    maxY = Math.max(j,maxY); 
                }
            }
        }
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX+1;
        answer[3] = maxY+1;
        return answer;
    }
}

// 0 1 0 0 0
// 0 0 1 0 0
// 0 0 0 1 0
    