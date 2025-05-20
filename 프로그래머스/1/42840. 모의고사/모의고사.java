import java.util.*;

import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = new int[3];
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==a[i%5]){
                score[0]++;
            }
            if(answers[i]==b[i%8]){
                score[1]++;
            }
            if(answers[i]==c[i%10]){
                score[2]++;
            }
        }
        
        int maxScore = Arrays.stream(score).max().getAsInt();

        return IntStream.range(0, 3)
                .filter(i -> score[i] == maxScore)
                .map(i -> i + 1)
                .toArray(); // ← 여기서 int[]로 반환
    }
        // int result = Math.max(score[0],Math.max(score[1],score[2]));
       
}