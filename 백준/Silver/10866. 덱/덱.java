import java.util.*;
import java.io.*;
/*
Queue(큐)는 선입선출/ 데이터 입구,출구 반대/에스컬레이터/단방향 자료구조
역방향으로 참조하거나 반대로 넣어야 할 경우 Deque(덱)사용
입구와 출구를 양쪽에 모두 만든 자료구조

offer/offerLast ---> {deque} ---> poll/pollFirst
       pollLast <--- {deque} <--- offerFirst 
*/
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> q = new LinkedList<>(); 
        int N =Integer.parseInt(br.readLine());
        //offer/offerLast얘네가 같은게 좀 헷갈려
        //이럴땐 그냥 offerLast /  first 이걸로구분하자
        //참고로 poll이랑 offer은 같은 first or last야
        while(N -->0){
           StringTokenizer st = new StringTokenizer(br.readLine()," ");
            //문자열을 " "을 기준으로 구분
            switch(st.nextToken()){
                case"push_front" :
                    q.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                    
               case"push_back" : 
                    q.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                    
                case "pop_front" :
                    if(q.isEmpty())
                        bw.write(-1+"\n");
                    else
                        bw.write(q.pollFirst()+"\n");
                    break;
                    
                case "pop_back" :
                    if(q.isEmpty())
                        bw.write(-1+"\n");
                    else
                        bw.write(q.pollLast()+"\n");
                    break;
                    
                case "size" :
                    bw.write(q.size()+"\n");
                    break;
                    
                case "empty" : 
                    if(q.isEmpty())
                        bw.write(1+"\n");
                    else
                        bw.write(0+"\n");
                    break;

                 case "front" : 
                    if(q.isEmpty())
                        bw.write(-1+"\n");
                    else
                        bw.write(q.peek()+"\n");
                    break;
                        
                 case "back" : 
                    if(q.isEmpty())
                        bw.write(-1+"\n");
                    else
                        bw.write(q.peekLast()+"\n");
                    break;
                    
            }
        }
        bw.flush();
    }
}