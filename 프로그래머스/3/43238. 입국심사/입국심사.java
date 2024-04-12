/*
1. 값이 크다! 이분탐색을 사용해보자
2. 특정 시간이 가능한지 불가능한지 판별하는 메소드를 구현
> 어떻게? 시간 / time을 합하여 n보다 큰지?
3. 가능하면 그시간이 right, 불가능하면 left
*/

class Solution {
    public static boolean isPossible(int n, int[] times, long can){
        long count = 0;
        for(int time : times){
            count += (long) (can / time);
        }
        if(count >= n) return true;
        else return false;
    }
    
    public long solution(int n, int[] times) {
        long left = 0;
        long right = 1000000000L * 1000000000L;
        long mid = 0;
        
        while(left < right){
            mid = (left + right) / 2; 
            if(isPossible(n,times,mid)){
                right = mid;
            }else{
                left = mid +1;
            }
        }
        return left;
    }
}