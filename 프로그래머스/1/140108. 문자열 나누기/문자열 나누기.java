import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        char x = s.charAt(0);
        int answer = 1;
        int count = 1;
        
        for(int i=1;i<s.length();i++){
            if(count==0){
                answer++;
                x = s.charAt(i);
            }
            if(x==s.charAt(i)){
                count++;
            }else{
                count--;
            }
        }
            
        return answer;
    }
    
}