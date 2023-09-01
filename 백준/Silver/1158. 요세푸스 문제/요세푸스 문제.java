import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        //<>요거때매 각각 이어서 붙여줄거라 누적되어 출력할 수 있도록 설정
        
        for(int j=1; j<=N ;j++){
            //순서대로 넣으려고 while(n-->0)은 안했어 그럼 큰거에서 작은거 순으로 들어가자나
            que.offer(j); //일단 1~n까지 큐에 넣는다
          
        }
        
        sb.append("<");
        
        while(que.size()!=1){//숫자랑 ,랑 같이 출력할건데 마지막 숫자는 ,빼고 출력해야해서
            for(int i = 0; i<K-1; i++){
                //k번째 숫자 그 앞에 있던 숫자들은 맨뒤로 가서 (순서)줄을 다시 서야한다
                que.offer(que.poll()); //뒤에넣기(뺀애들)
                           
            }
                            sb.append(que.poll()+", ");
                // k가 맨앞으로 왔자나?
                // que는 선입선출이니까 그럼 k빼주기    
        }
        sb.append(que.poll() + ">"); //마지막 1개 빼주기
        bw.write(sb.toString());
        bw.flush();
    }
}

//무슨이유인지는 모르겠으나 stringToken을 안쓰니까 런타임 오류가 났고
//while안의 for문에 sb.append를 넣었더니 오류가 났다
//내생각 offer은 여러번 반복하지만 출력은 맨앞에 한번씩만 진행하니까 따로 빼주는듯하다