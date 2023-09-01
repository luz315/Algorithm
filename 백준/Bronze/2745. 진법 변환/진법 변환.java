//10진법으로 넘어가는수 중에 숫자가 안되는 애들은 알파벳 대문자라고 했으니까
//B진법 수는 영어 대문자 OR 숫자
//대문자면 55를 빼주기
//숫자면 '0'을 빼주기
//빼준 숫자에 B의 제곱수를 곱해주면 끝!
//제곱:Math.pow 메소드

import java.util.*;
import java.math.*;

public class Main {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      String n = sc.next(); //문자
      int b = sc.nextInt(); //진법
      int sum=0;
	  int num=0;
		
		for(int i=0;i<n.length();i++) {
			if(n.charAt(i)>=65){//아스키 코드보면 대문자 A부터는 65
                num=n.charAt(i)-55;//대문자
            }
			else {
            num=n.charAt(i)-'0';//숫자
            }
			sum += num*Math.pow(b,n.length()-i-1);//(진법,n.length-1)
            
		}
      System.out.println(sum); 
  }
}