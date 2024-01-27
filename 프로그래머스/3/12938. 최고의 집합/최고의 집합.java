class Solution {
    public int[] solution(int n, int s) {
        
        if(n > s) {
            return new int[]{-1};
        }
        
        int quot = s / n;
        int rem = s % n;
        
        int[] answer = new int[n];
        
        for(int i = 0 ; i < n ; i ++){
            answer[i] = quot;
        }
        
        for(int i = 0 ; i < rem ; i ++){
            answer[n - (1 + i)]++;
        }
        
        
        
        
        return answer;
    }
}