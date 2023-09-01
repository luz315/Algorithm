import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*10이 넘어가면 알파벳으로 표기
  알파벳 a:10 ... z:37(총 36개)
  진법변환
  진법으로 숫자를 나눴을때 그 나머지가 그진법의 새로운 숫자
  ex) 2/17 ...1
      2/8  ...0
      2/4  ...0
      2/2  ...0
      2/1 
      
      즉 17을 2진법으로 나타내면 10001이다. 
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        
        /* String: 문자열 추가안됨 새로운 스트링 객체로 리턴
           StringBuilder: 문자열 누적 추가 가능
           append가 StringBuilder의 문자열 추가 표현임
        */
        

       
        while(N > 0){
            if(N%B >= 10) sb.append((char)((N % B) + 55)); //대문자 변환
            else sb.append(N%B);
            N /= B; // n = n/b
        }

        System.out.println(sb.reverse().toString());
        //뒤집는 이유는 밑에처럼 가장 마지막에 나눠진 수 부터 숫자 시작이므로 
        /*  ex) 2/17 ...1
                2/8  ...0
                2/4  ...0
                2/2  ...0
                2/1 
      */              
    }
}