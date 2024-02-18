class Solution {
    static int answer;
    
    public int solution(int n) {
        answer = 0;
        dfs(n,0);
        return answer;
    }
    
    public void dfs(int n, int plusCount){
        if(n < 3 || n < Math.pow(3, plusCount / 2)){
            return;
        }
        else if(n == 3){
            if(plusCount == 2){
                answer ++;
            }
        }
        else if(n > 3){
            if(n % 3 == 0 && plusCount >= 2){
                dfs(n/3 , (plusCount-2));
            }
            dfs(n - 1 , plusCount + 1);
        }
        
    }
}