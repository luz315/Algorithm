import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int t = 1; t <= T; t++)
		{
            long N = sc.nextLong();
            long A = sc.nextLong();
            long B = sc.nextLong();
            long min = Long.MAX_VALUE;

            for(long R = 1; R<=Math.sqrt(N); R++ ){
                for(long C =R; C*R<=N; C++){
                    long temp = A*Math.abs(R-C) + B*(N-(R*C));
                    if(temp < min) min = temp;
                }
            }
            System.out.println("#"+t+" "+min);
        }
	}
}