/*
1. dp[i] = max(dp[i - 1], dp[i-2]+ money[i]) 
2. money 배열은 2개로 dp 2번 마지막 0, 첫번째 0
3. 맨 끝 dp 값 비교
*/

class Solution {
    public static int[] dp;
    
    public static void initDP(int length){
        dp = new int[length];
    }
    
    public int getMax(int[] money){
        dp[0] = money[0];
        if(money[0] < money[1]){
            dp[1] = money[1];
        }else{
            dp[1] = money[0];
        }
        
        for(int i = 2 ; i < money.length ; i++){
            dp[i] = Math.max(dp[i-1] , dp[i-2] + money[i]);
        }
        
        return dp[money.length - 1];
    }
    
    public int solution(int[] money) {
        int answer = 0;
        
        int first = money[0];
        int last = money[money.length-1];
  
        money[money.length-1] = 0;
        
        initDP(money.length);
        int num1 = getMax(money);

        money[money.length-1] = last;
        money[0] = 0;
        
        initDP(money.length);
        int num2 = getMax(money);
        
        answer = Math.max(num1,num2);
        
        
        return answer;
    }
}