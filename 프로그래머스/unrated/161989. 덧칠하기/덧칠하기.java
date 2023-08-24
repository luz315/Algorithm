class Solution {
    public int solution(int n, int m, int[] section) {
        int result = 0;
        int start = 1;
        
        for (int i = 0; i < section.length; i++) {
            if (start <= section[i]) {
                result ++;
                start = section[i] + m;
            }
        }
        
        return result;
    }
}