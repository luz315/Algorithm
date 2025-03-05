import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character,Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];
        for(String k:keymap){
            for(int i=0;i<k.length();i++){
                char c = k.charAt(i);
                if(!map.containsKey(c) || i+1<map.get(c)){
                    map.put(c, i+1);
                }
            }
        }
        for(int i=0;i<targets.length;i++){
            int count = 0;
            for(char c: targets[i].toCharArray()){
                if(map.containsKey(c)){
                    count+=map.get(c);
                }
                else{
                    count = -1;
                    break;
                }
            }
            answer[i] = (count > 0) ? count:-1;
        }
        return answer;
    }
}