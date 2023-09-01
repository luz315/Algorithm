//https://st-lab.tistory.com/182 참고할 것

import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringBuilder sb = new StringBuilder();
     Stack<Integer> stack = new Stack<>();
     int a = Integer.parseInt(br.readLine());
     int s = 0;
     while(a-->0){
         int n = Integer.parseInt(br.readLine());
         if(n>s){
             for(int i=s+1;i<n+1;i++){
                 // s는 현재위치
                 // n은 입력되는 수
                 // 즉 s의 초깃값은 0이다, 그럼 i가 1부터 시작해 원하는 n까지 push를 한다
                 // 그리고 현재위치 s를 n으로 변경한다 
                 // 그럼 다음번에 push할때 앞에서 1부터 다시 push하는게 아니라 
                 // n 다음 수부터 push 이어서 가능하다
                 stack.push(i);
                 sb.append('+').append('\n');
             }
             s = n;
         }
         else if(stack.peek()!= n){ //걍외워
             System.out.println("NO");
             return;
             
         }
         stack.pop(); // 후입선출
         sb.append('-').append('\n');
         
     }
        System.out.println(sb);
    }
}