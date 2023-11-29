import java.util.*;
class Solution {
    public long sum(int[] arr) {
        long a = 0;
        for(int i = 0; i < arr.length; i++) 
        {
            a += (long) arr[i];
        }
        return a;
    }
    public int solution(int[] queue1, int[] queue2) {
        
        int answer = 0;
        long sum_q1 = sum(queue1);
        long sum_q2 = sum(queue2);
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>(); 
        
        
        for(int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);            
            q2.add(queue2[i]);
        }
        
        while(sum_q1 != sum_q2) {
            if(answer > queue1.length * 3)
                return -1;
            
            int add_num = 0;
            
            if(sum_q1 < sum_q2) {
                add_num = q2.poll();
                q1.add(add_num);
                sum_q1 += (long) add_num;
                sum_q2 -= (long) add_num;
            }
            
            else if(sum_q1 > sum_q2) {
                add_num = q1.poll();
                q2.add(add_num);
                sum_q1 -= (long) add_num;
                sum_q2 += (long) add_num;
            }
            
            else return answer;
            
            answer++;
            
        }
        return answer;
    }
}