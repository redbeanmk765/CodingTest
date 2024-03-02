class Solution {
    private int dp[][];
    
    private void initDP(){
        
        dp = new int[100001][2];
        
        for(int m = 1 ; m <= 3 ; m++){
            for(int i = 1 ; i <= 20 ; i ++){
                dp[i * m][0] = 1;
                if(m == 1){
                    dp[i][1] = 1;
                }
            }
        }
        dp[50][0] = 1;
        dp[50][1] = 1;
    }
    
    public void searchDP(int num, int maxScore){
        int minDart = num; // 최대는 1점 다트로만
        int maxSingle = 0;
        
        
        for(int i = 1 ; i <= maxScore ; i++){
            if(dp[i][0] != 1){
                continue;
            }
            
            int tmpDart = dp[num - i][0] + 1;
            int tmpSingle = dp[num - i][1];
            if(dp[i][1] == 1){
                tmpSingle++;
            }
            
            if(tmpDart < minDart || (tmpDart == minDart && tmpSingle > maxSingle)){
                minDart = tmpDart;
                maxSingle = tmpSingle;
            }
        }
        
        dp[num][0] = minDart;
        dp[num][1] = maxSingle;
    }
    
    public int[] solution(int target) {
        int[] answer = {};
        
        initDP();
        
        for(int i = 21 ; i <= target ; i++){
            if(i <= 60){
                if(dp[i][0] != 1){
                    searchDP(i, i-1);
                }
            }
            else{
                searchDP(i,60);
            }
        }
        
        
        
        answer = dp[target];
        return answer;
    }
}