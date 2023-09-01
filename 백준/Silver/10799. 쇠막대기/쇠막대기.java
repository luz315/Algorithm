//막대기라 판정되면 size+1해서 막대기 개수를 늘려주고
//레이저라 판정되면 두동강이 나니까 size만큼 업시켜준다
//size라는게 그때그때 남은 ( 개수만큼 더해준다

//)는 무조건 push 근데 바로 직전에 ( 나오면 pop해서 직전( 빼줘 
//)는 바로 직전에 ) 였더라도 pop은 해줘야대 막대기가 쌍을 이뤘자나 
//막대기는 (/) 둘이 만나서 하나의 막대를 이루는 거기때문에 (만으로 막대의 개수를 가늠할 수 있어

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        
/*  1.(나온다: 그럼 push     
    2.)나온다: 바로 앞이 ) 경우 - 막대기니까 사이즈 +1
            : 바로 앞이 ( 경우 - 레이저니까 스택길이만큼 더하기
*/
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();
        int size = 0;
        
        for(int i =0; i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push('(');
            
            else {
                if(s.charAt(i-1)=='('){ //직전에 (나온 건 레이저란 말
                    stack.pop(); //  (를 빼버려 계산 다했자낭
                    size+=stack.size(); // size up
                }
                else {//직전에 )나온 건 막대기의 일부
                    stack.pop();
                    size+=1; //사이즈만 1 up
                }
            }
        }
        System.out.println(size);
    }
}