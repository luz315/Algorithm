import java.util.*;
class Solution {
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visit = new boolean[words.length]; 
        
        Queue<String> q = new LinkedList<>(); 
        q.add(begin); 
        while (!q.isEmpty()) { 
            int size = q.size(); 

            for (int i = 0; i < size; i++) {
                String current = q.poll(); 

                if (current.equals(target)) { 
                    return answer; 
                }

                for (int j = 0; j < words.length; j++) {
                    if (!visit[j] && diff(current, words[j])) {
                        visit[j] = true; 
                        q.add(words[j]); 
                    }
                }
            }
            answer++; 
        }
        return 0;
    }

    private boolean diff(String from, String to) {
        int count = 0; 

        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                count++; 
            }

            if (count > 1) {
                return false;
            }
        }

        return count == 1; 
    }
}