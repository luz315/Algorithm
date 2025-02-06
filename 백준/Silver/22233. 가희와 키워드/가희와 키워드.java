import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        while (N-- > 0) {
            map.put(br.readLine(), 1);
        }

        while (M-- > 0) {
            String[] str = br.readLine().split(",");
            for (String s : str) {
                map.remove(s);
            }
            
            System.out.println(map.size());
        }
    }
}
