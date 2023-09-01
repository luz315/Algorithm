/*여는 괄호를 만나면 stack에 push
닫는 괄호를 만났을 때
stack에 여는 괄호가 존재한다면 stack의 값을 pop
여는 괄호가 없다면 실패처리
마지막으로 모든 탐색을 끝냈는데 stack에 남아있다면 실패처리
*/
import java.io.*;
import java.util.*;
 public class Main{
     public static void main(String[] args)throws IOException{
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           int n = Integer.parseInt(br.readLine());
           StringBuilder sb = new StringBuilder();
           while(n-->0) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            boolean b = true;  //b가 true면 YES, false면 NO
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    // '('면 스택에 push 
                    stack.push('(');
                } else {
                    // ')'면 스택에서 pop
                    if (stack.isEmpty()) {
                        b = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) b = false;
               
            if (b) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}