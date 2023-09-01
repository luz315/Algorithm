import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        double[] arr = new double[n];
        for(int i =0;i<n;i++){
              arr[i]=Double.parseDouble(br.readLine());
        }
        
        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            if(c>=65 && c<=90){
                stack.push(arr[c-'A']);
            }
            else{
                 double a = stack.pop();
                 double b = stack.pop();
                switch (c) {
                        case '+':
                            stack.push(b+a);
                            continue;
                        case '-':
                            stack.push(b-a);
                            continue;
                        case '*':
                            stack.push(b*a);
                            continue;
                        case '/':
                            stack.push(b/a);
                            continue;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
        br.close();
    }
}