import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> m = new HashMap<>();
        
        for(int i = 0; i<players.length;i++){
            m.put(players[i],i); //현 순위
        }
        
        for(String call : callings){
            int lank = m.get(call);
            m.put(call, lank-1);
            m.put(players[lank - 1], lank);
            players[lank] = players[lank - 1]; 
            players[lank - 1] = call;  
        }
        return players; 
    }
}
        