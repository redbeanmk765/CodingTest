/*
1. DP문제다. 어떻게? 점화식을 세워보자.
2. 가능한 연산 = 더하기, 빼기, 곱하기, 나누기, 숫자 붙히기
3. dp는 무엇을 기준으로? 계산된 수? 사용한 숫자 수?
4. 그렇다면 기존 dp를 int벡터로?
> 벡터가 아니라 list, 그리고 set을 활용하자
*/

import java.util.ArrayList;
import java.util.HashSet;


class Solution {
    public static ArrayList<HashSet<Integer>> sets;
    
    public static void init(int N){
        sets = new ArrayList<>();
        int tmp = 0;
        
        for(int i = 0 ; i <= 8 ; i++){
            sets.add(new HashSet<>());
            
            if(i >= 1){
                tmp = tmp * 10 + N;
                sets.get(i).add(tmp);
            }
        }
    }
    
    public static int searchDp(int number){
        for(int i = 2 ; i <= 8 ; i++){
            for(int j = 1 ; j < i ; j++){
                for(int left : sets.get(i-j)){
                    for(int right : sets.get(j)){
                        sets.get(i).add(left + right);
                        sets.get(i).add(left - right);
                        sets.get(i).add(left * right);
                        if(right != 0){
                            sets.get(i).add(left / right);
                        }
                    }
                }
            }
            if(sets.get(i).contains(number)){
                return i;
            }
        }
        
        return -1;
    }
    
    public int solution(int N, int number) {
        
        if(N == number) return 1;
        
        
        int answer = 0;
        
        init(N);
        
        
        answer = searchDp(number);
        
        return answer;
    }
}