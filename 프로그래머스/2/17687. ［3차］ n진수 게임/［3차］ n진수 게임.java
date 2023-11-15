class Solution {
    public String solution(int n, int t, int m, int p) {
       StringBuilder num = new StringBuilder(); 
        StringBuilder result = new StringBuilder();
        
       for(int i = 0; num.length() <= t * m; i++){
            num.append(Integer.toString(i, n).toUpperCase());
        }
      
        for(int i = p - 1;  result.length() < t; i += m){
            result.append(num.charAt(i));
        }
        
        return result.toString();
 
    }
}