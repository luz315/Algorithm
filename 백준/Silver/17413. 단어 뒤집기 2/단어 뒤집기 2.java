import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        //스택은 거꾸로 빼니까 굳이 큐를 쓸필욘 없어
        boolean test = false;
        
        for(int i = 0; i<str.length(); i++){
           if(str.charAt(i) == '<') {
				test = true;
	
				while( !stack.isEmpty() ) {
					sb.append(stack.pop()); // 스택 안이 빌때까지 다 빼버려
				}
	
				sb.append(str.charAt(i)); //<인 문자만 출력
			}
			else if(str.charAt(i) == '>') {
				test = false;
				sb.append(str.charAt(i));//<만 출력된 상황에서 >인 문자만 출력
			}
            
			else if(test == true) {//<>로 이루어진 단어만 나타낼 수 있어
				sb.append(str.charAt(i));
			}
            //이해는 안가지만 boolean 사용해서 charAt하면
            //<> 안의 문자 모두 출력이 가능
            
            
            else if( test == false) {//<>외의 문자도 나타낼 수 있어
				if(str.charAt(i) == ' ') {
	
					while( !stack.isEmpty() ) {
						sb.append(stack.pop());
					}// 싹다 빼버리기
	
					sb.append(str.charAt(i)); //다시 공백넣기
				}
				// 공백이 아닐경우, 공백을 만날 때 까지 stack에 push
				else {
					stack.push(str.charAt(i)); //숫자넣기
				}
			}
        
        }
        while( !stack.isEmpty() ) {
			sb.append(stack.pop()); // 거꾸로 빼기
		}
        
       System.out.println(sb);
    }
}