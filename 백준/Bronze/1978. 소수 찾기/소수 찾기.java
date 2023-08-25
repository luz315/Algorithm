import java.util.*;
import java.io.*;
public class Main{
  	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine(); 
		int result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			boolean test = true;
			int num = Integer.parseInt(st.nextToken());
			if (num == 1)
				continue; 
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					test = false;
					break;
				}
			}
			if (test) {
				result++;
			}
		}
		System.out.println(result);
	}
}