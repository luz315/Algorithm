import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();  // 스택 선언
        int n = Integer.parseInt(br.readLine()); // 첫째줄 입력 N
        for (int i = 0; i < n; i++) {
        String s = br.readLine(); // integer 안써도 돼
        //contains, equals 차이
        //contains: string 문자열에 포함되어있는지
        //equals: string 문자열과 동일한지
           
           if(s.contains("push")){
                String spt[] = s.split(" ");
				stack.push(Integer.parseInt(spt[1]));
                //다른방법
                //StringTokenizer st = new StringTokenizer(br.readLine());
                //String s = st.nextToken();
                //if(s.equals("push")){stack.push(Integer.parseInt(st.nextToken()));}
            }
            
            else if(s.contains("pop")){
                if(stack.empty()){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(stack.pop()+"\n");
                }
            }
            
            else if(s.contains("size")){
                bw.write(stack.size()+"\n");
            }
            
            else if(s.contains("empty")){
                if(stack.empty()){
                    bw.write(1+"\n");
                }
                else{
                    bw.write(0+"\n");
                }
            }
            
            else if(s.contains("top")){
                if(stack.empty()){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(stack.peek()+"\n");
                }               
            }        
        }
     bw.flush();   
    }
}