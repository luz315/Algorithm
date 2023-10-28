import java.util.*;
import java.io.*;
public class Main{
    static int N;
    static int arr[];
    static int cal[] = new int[4];
    static int max = Integer.MIN_VALUE;    
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());        
        }
         st = new StringTokenizer(br.readLine());
        for(int j=0;j<4;j++){
            cal[j] = Integer.parseInt(st.nextToken());
        }
        Back(arr[0],1);
        System.out.println(max);
        System.out.println(min);
    }
    
    public static void Back(int step, int index){
        if(index == N){
            max = Math.max(max,step);
            min = Math.min(min,step);
            return;
        }
        for(int i=0; i<4; i++){
            if(cal[i]>0){
                cal[i]--;
            
                switch(i){
                    case 0:
                        Back(step + arr[index], index+1);
                        break;
                 
                    case 1:
                        Back(step - arr[index], index+1);
                        break;
                        
                    case 2:
                        Back(step * arr[index], index+1);
                        break;
                    
                    case 3:
                        Back(step / arr[index], index+1);
                        break;
                }
                cal[i]++;
            }
       
        }
       
    }
}