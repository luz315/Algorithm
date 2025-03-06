import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        char arr[][] = new char[park.length][park[0].length()];
        int start[]= new int[2];
        
        for(int i=0;i<park.length;i++){
            arr[i]=park[i].toCharArray();
            for(int j=0;j<park[0].length();j++){
                if(arr[i][j]=='S'){
                    start[0]=i;
                    start[1]=j;
                }
            }
        }
        
        for(String r:routes){
            String[] s = r.split(" ");
            int num = Integer.parseInt(s[1]); 
            int nx = start[0];
            int ny = start[1];
            for(int i=0;i<num;i++){
                switch(s[0]){
                    case "E": ny++; break;
                    case "S": nx++; break;
                    case "W": ny--; break;
                    case "N": nx--; break;
                }
                
                if (nx < 0 || nx >= park.length || ny < 0 || ny >= park[0].length() || arr[nx][ny] == 'X') {
                    break;
                }
                
                 if (i == num - 1) {
                    start[0] = nx;
                    start[1] = ny;
                }
            }
        }
        return start;
    }
}