import java.util.*;
import java.io.*;

public class Main {

    static int N,d,k,c,sushi[],eating[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 N = Integer.parseInt(st.nextToken()); // 접시의 수
		 d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		 k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		 c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		 sushi = new int[N];
		 eating = new int[d+1]; // 먹은 초밥 
		
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(slide());
    }
        
        private static int slide() {
		// 회전하지 않았을 때 경우
        eating[c] = 3001;
		int count = 1;
		for(int i=0; i<k; i++) {
			if(eating[sushi[i]] <= 0) count ++;
			eating[sushi[i]] ++;
		}
		
		int max = count;
		for(int i=0; i<N-1; i++) {
			// i ~ i+k-1 == start ~ end-1
			int start = i;
			int end = i+k >= N ? (i+k)%N : i+k;
			
			// start 뺐는데 갯수가 0이하면 종류 하나 빼기
			if(--eating[sushi[start]] == 0) count-- ;
			// end 넣는데 갯수가 1개이면 종류 하나 추가
			if(++eating[sushi[end]] == 1) count ++;
			
			max = Math.max(max, count);
		}
		
		return max;
	}

}