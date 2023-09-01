import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());

		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
        
        //a,b,c,d left 스택에 넣기 늘 왼쪽스택이 기준
        for(int i = 0;i<str.length();i++){
         left.push(str.charAt(i));
         }
        StringBuilder sb = new StringBuilder();
        //위치이동=커서의 기준으로 생각할 것 
        while(M-->0){
            String s = br.readLine();
            switch(s.charAt(0)) {
			case 'L':
                    if(!left.isEmpty())//왼쪽에 문자 있어야돼 그래야 왼쪽으로 옮기지
					right.push(left.pop());
                    //커서를 왼쪽으로 옮기면 문자는 커서의 오른쪽으로 간다
                    //왼쪽스택에서 빼서 문자를 잠시 오른쪽스택으로 보낸다
                    break;
                    
			case 'D':
                    if(!right.isEmpty())//오른쪽에 문자 있어야돼 그래야 오른쪽으로 옮기지
					left.push(right.pop());
                    //커서를 오른쪽으로 옮기려면 문자는 커서의 왼쪽으로 간다
                    //즉 오른쪽에 있었던 문자를 커서이동하면서 왼쪽에있는 스택에 넣어줘야해
                    break;
                    
			case 'B':
                    if(!left.isEmpty())//왼쪽에 문자 있어야돼 그래야 삭제하지
				    left.pop();
                    //커서 왼쪽에 있는 문자를 삭제한다
                    //커서 기준으로 오른쪽애들은 변함이 없다
                    //즉 왼쪽스택에서만 하나 제거
                    break;
                    
			case 'P':
                   
			     	left.push(s.charAt(2));
			    	//커서 왼쪽에 추가
                    //p하고 공백 그다음 문자니까 2번째 문자를 넣는다
                    break;
        }
        }
        while(!left.isEmpty()){ //오른쪽으로 다몰거야 출력할때 빼려면 모두다 거꾸로 되기 때문에
            right.push(left.pop()); //왼쪽기준이라 왼쪽말고 오른쪽 일부러 거꾸로 몰고 뺀다
        }                          // 그럼 나중에 따로 reverse 안해줘도 돼
        while(!right.isEmpty()){
            bw.write(right.pop()); 
        }
        bw.flush();
    }
}