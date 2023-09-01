//01234567
//backjoon
//각각의 알파벳에 인덱스번호 붙이고
//알파벳을 처음부터 쭉 정렬했을때 인덱스 붙인 알파벳은 해당 알파벳 붙이고 
//없는 알파벳은 다 -1 주기

import java.io.*;

//아스키코드: A(65) ~ Z(90)
//           a(97) ~ z(122)

// 알파벳(소문자)을 'a'로 빼주면 a(0) ~ z(25)와 같이 index로 사용하기 좋게 나온다. 
// 그냥 a(97) ~ z(122)로 사용해도 괜춘
// 단, 알파벳 위치를 담고 있는 배열의 공간을 123으로 확보해야 한다. 
// 출력도 index 97부터 해줘야 한다.
// 그냥 빼주는 게 최고

//indexOf(): 특정문자나 문자열이 처음발견되는 인덱스를 반환하고 찾지못하면 -1을 반환
//           :(찾을문자,시작할위치)

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        for(char i='a';i<='z';i++){
           System.out.print(s.indexOf(i)+" ");
        }
    }
}