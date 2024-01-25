class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int curMoney : money){
            for(int i = curMoney ; i <= n ; i++){
                dp[i] += dp[i-curMoney]; 
            }
        }
        
        
        answer = dp[n];
        return answer;
    }
}