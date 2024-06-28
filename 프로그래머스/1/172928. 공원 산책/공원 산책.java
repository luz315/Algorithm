import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        char arr[][] = new char[park.length][park[0].length()];
        int result[] =new int[2];
        int sx = 0;
        int sy = 0;
        
        for(int i=0;i<park.length; i++){
            arr[i]=park[i].toCharArray();
            for(int j=0; j<park[0].length();j++){
                if(arr[i][j]=='S'){
                     sx=i;
                     sy=j;
                }
            }
        }
        
        
        for(String route : routes){
            String dir = route.split(" ")[0];
            int move = Integer.parseInt(route.split(" ")[1]);
            int nx = sx;
            int ny = sy;
            
            for(int j=0; j<move; j++){
                switch(dir){
                    case "E": ny++; break;
                    case "W": ny--; break;
                    case "N": nx--; break;
                    case "S": nx++; break;
                }
                 if (nx < 0 || ny >= park[0].length() || ny < 0 || nx >= park.length || arr[nx][ny] == 'X') {
                    nx = sx; 
                    ny = sy;
                    break;
                }
                
                else if (j == move - 1) {
                    sx = nx;
                    sy = ny;
                }
            }
            
        }
        result[0] = sx; 
        result[1] = sy; 
        return result;
    }
}