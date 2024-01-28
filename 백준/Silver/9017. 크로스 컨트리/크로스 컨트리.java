import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()), i, n, team,j;
        StringTokenizer st;
        while (T-->0){
            n = Integer.parseInt(br.readLine()); // 각 테스트케이스의 첫째줄 입력
            int count[] = new int[202]; // 인원수 파악
            int teamNum[] = new int[n]; // 각 테스트케이스의 둘째줄 입력 (각 선수의 팀 번호)
            st = new StringTokenizer(br.readLine());
            for (i = 0; i < n; i++){
                teamNum[i] = team = Integer.parseInt(st.nextToken()); 
                // 팀번호를 그냥 객체 / 배열 둘다에 저장한다
                count[team]++; // 팀번호별 인원수 파악을 위해서 팀번호를 인덱스로 저장해서 카운트하기
            }
            int score[] = new int[202]; // 점수 저장

            int passTeam[] = new int[202]; // 6명이상인 팀 인원수 저장을 위해(= 통과한 팀)
            int minscore = 1<<30, minteam = -1;
            
            for (i = 0, j=1; i < n; i++){ // 다시한번 계산 점수 땜에
                team = teamNum[i]; // 질문) i 없애고 위에있는 team가져오면 안되는건가?
                if (count[team] < 6) // 인원수가 6아래면 계산에서 제외
                    continue;
                passTeam[team]++; // 인원수 6인 팀만 인원수 추가
                if (passTeam[team] <= 4) // 팀번호별 인원수 4까지만 점수 계산
                    score[team] += j << 19; // 팀별 점수에 등수 갱신하기
                if (passTeam[team] == 5){ // 인원수 5일때도 추가로 계산해놓기
                    score[team] += j; // 팀별 점수에 등수 계산
                    if (score[team] < minscore){ // 결과가 계산된 팀 점수보다 크다면
                        minscore = score[team]; // 결과는 팀점수 
                        minteam = team; // 결과는 해당팀이 된다 
                    }
                }

                j++;
            }
            System.out.println(minteam);
        }
    }
}