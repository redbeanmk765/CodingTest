import java.util.Arrays;

class Solution {
    public int solution(int[][] m) {
        int size = m.length;
        int answer = 0;
        int[][] dp = new int[size][size];
        
        for(int i = 0 ; i < size ; i++){
             for(int j = 0 ; j < size ; j++){
                dp[i][j] = 2147483646;
             }
        }
        
        for(int i = 0 ; i < size ; i++){
            dp[i][i] = 0;
        }
        
        for(int i = 0 ; i < size ; i++){
            
            for(int j = 0 ; j < size - i ; j++){
                int s = j;
                int e = j + i;
                
                for(int k = s ; k < e ; k++){
                    dp[s][e] = Math.min(dp[s][e], dp[s][k] + dp[k+1][e] + (m[s][0] * m[k][1] * m[e][1]));
                }
            }
        }
        answer = dp[0][size-1];
        return answer;
    }
}