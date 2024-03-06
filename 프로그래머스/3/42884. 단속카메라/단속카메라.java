import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);
        
        int left = -30001;
        int right = 30001;
        for(int[] route : routes){
            if(route[0] > right){
                answer++;
                left = route[0];
                right = route[1];
            }else{
                left = route[0];
                if(right > route[1]){
                    right = route[1];
                }
            }
        }
        answer++;
        return answer;
    }
}