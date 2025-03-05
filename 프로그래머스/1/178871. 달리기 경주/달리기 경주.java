import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
    
        for(int i=0;i<players.length;i++){
            map.put(players[i],i);            
        }
        
        for(String s:callings){
            int num = map.get(s);
            map.put(s,num-1);
            map.put(players[num-1],num);
            players[num] = players[num-1];
            players[num-1] = s;
        }
        
        return players;
    }
}
        