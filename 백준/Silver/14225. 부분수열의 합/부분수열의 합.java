import java.io.*;
import java.util.*;

public class Main {
	static int N,max=0;
	static int[] S,num;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
    	N = Integer.parseInt(br.readLine());
    	S = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //수열 S의 값들과 최대값을 구하였습니다.
    	for(int i=0;i<N;i++) {
    		S[i] = Integer.parseInt(st.nextToken());
    		max += S[i];
    	}
       	num = new int[max+2];	//해당 자연수가 존재하는지 확인하는 배열
    	cal(0,0);		//수열 S의 대한 순열로 모든 경우의 자연수를 만들어보는 함수 실행
        //나올 수 없는 자연수 중 가장 작은 자연수 BufferedWriter 저장
    	for(int i=1;i<=max+1;i++) {
    		if(num[i]==0) {
    			bw.write(i + "\n");
    			break;
    		}
    	}
    	bw.flush();		//결과 출력
    	bw.close();
    	br.close();
    }
    //수열 S의 대한 순열로 모든 경우의 자연수를 만들어보는 함수
    static void cal(int cur, int sum) {
    	for(int i=cur;i<N;i++) {
    		int temp = sum+S[i];
        	num[temp] = 1;
        	cal(i+1, temp);
    		}
    	return;
    }
}