/*
1. 단순한 대입으로는 데이터가 크다. 이분탐색을 사용해보자
2. 특정 번호까지의 enemy 값을 전부 합했을때, 가장 큰 값 k개를 차한것이 n보다 작다면 가능하다
> 내림차순?
3. 
*/

import java.util.Arrays;

class Solution {
    public static Boolean isPossible(int n, int k, int[] enemy, int max) {
        if(k >= max){
            return true;
        }
        int[] tmp = new int[max];
        for(int i = 0 ; i < max ; i++){
            tmp[i] = enemy[i];
        }
        Arrays.sort(tmp);
        
        double sum = 0;
        
        for(int i = 0 ; i < max - k ; i++){
            sum += tmp[i];
        }
        
        if(sum <= n){
            System.out.println("true");
            return true;
        }
        System.out.println("false");
        return false;
    } 
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        if(k >= enemy.length){
            return enemy.length;
        }
        
        int left = k;
        int right = enemy.length;
        int mid = 0;
        
        while(left <= right){
            mid = (left + right) / 2;
            System.out.println(left + " " + mid + " " + right);
            if(isPossible(n,k,enemy,mid)){
                left = mid+1;
                continue;
            }else{
                right = mid-1;
                continue;
            }
        }

        return right;
    }
}