import java.util.*;

class Solution {
    public List<String> solution(String[] record) {
       
        Map<String, String> map = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();
               
        for(int i = 0; i<record.length; i++){
            String[] spt =record[i].split(" ");
            if(spt.length == 3)
                map.put(spt[1], spt[2]);
        }
        
        for(int i = 0; i<record.length; i++){
           String[] spt =record[i].split(" ");
      
            switch(spt[0]){
                case "Enter":
                    answer.add(map.get(spt[1])+"님이 들어왔습니다.");
                break;
          
                case "Leave":
                    answer.add(map.get(spt[1])+"님이 나갔습니다.");
                break;
            }
        }                   
        return answer;
    }
}