class Solution {
    
    public boolean isPossible(int a, int b, int[] g, int[] s, int[] w, int[] t, long time){
        long maxMetal = 0;
        long maxGold = 0;
        long maxSilver = 0;
        
        for(int i = 0; i < g.length ; i++){
            long truckCount = time / (t[i] * 2);
            if(time % (t[i] * 2) >= t[i]){
                truckCount++;
            }
            
            long bestMetal = Math.min(w[i] * truckCount, g[i] + s[i]);
            
            maxMetal += bestMetal;
            maxGold += Math.min(bestMetal, g[i]);
            maxSilver += Math.min(bestMetal, s[i]);  
        }
        
        
        if(a + b <= maxMetal && a <= maxGold && b <= maxSilver){
            return true;
        }
        else{
            return false;
        }       
    } 
    
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        // 최대시간 = (10^9 + 10^9) * (10^5 * 2) = 400,000,000,000,000
        long hi = 400_000_000_000_000L;
        long lo = 0;
        
        while(lo + 1 < hi){
            long mid = (lo + hi) / 2;
            if(isPossible(a,b,g,s,w,t,mid) == true) {
                
                hi = mid;
            }
            else{
                lo = mid;
            }
        }
        answer = hi;
        return answer;
    }
}