import java.io.*;
import java.util.*;
public class Main{
      static int priority(char c){
        if(c=='+' || c=='-')
            return 1;
         else if(c=='*' || c=='/')
             return 2;
         else
             return 0;
     }
     public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
         
        String s = br.readLine();
         
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(c >= 'A') // 입력받은 문자 아스키 코드가 A이상 즉 알파벳이 나오면 바로 출력
                sb.append(c);
                
            else if(c== '(')
                    stack.push(c);
            
            
             else if(c==')'){
                    while(stack.peek()!='('){ //스택 peek가 (일때 멈추란말
                        sb.append(stack.pop());
                    } // ( 전까지 다뽑아
                    stack.pop(); // ( 뽑아
                   
             }
            
            else{
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                sb.append(stack.pop());
                }
            stack.add(c);
            }
        }
         
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        bw.write(sb.toString());
        bw.flush();
    }
}