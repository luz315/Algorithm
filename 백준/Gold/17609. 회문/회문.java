import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] arr = new String[T];
        for (int i = 0; i < T; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < T; i++) {
            String current = arr[i];
            System.out.println(point(0, current.length() - 1, current, 0));
        }
    }

    private static int point(int s, int e, String s1, int check) {
        // 시간초과를 해결하기 위해 아래 조건을 추가함
        if(check >=2) return 2;

        while (s < e) {
            if (s1.charAt(s) == s1.charAt(e)) {
                s++;
                e--;
            } else {
                return Math.min(point(s + 1, e, s1, check + 1), point(s, e - 1, s1, check + 1));
            }
        }
        return check;
    }
}