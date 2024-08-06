import java.io.*;
import java.util.*;
public class Main{
    static int count =0;
    static int arr[],N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        nQueen(0);
        System.out.println(count);
    }
    static void nQueen(int depth){
        if(depth==N){
            count++;
            return;
        }
        for(int i=0;i<N;i++){
            arr[depth] = i;
            if(pos(depth)){
                nQueen(depth+1);
            }
        }
    }
    static boolean pos(int col){
        for(int i=0;i<col;i++){
            if(arr[col]==arr[i]){
                return false;
            }
            else if (Math.abs(col-i) == Math.abs(arr[col]-arr[i])) {
				return false;
			}
        }
        return true;
    }
}