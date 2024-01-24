import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Arrays;

/*
다익스트라 3회 (시작, A도착, B도착)
1차원 배열만으로 구현가능
최후에 모든 지점에 대한 순회로 min값 구하기(그 지점에서 A + B + 시작)
*/

class Solution {

    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int Max = n*100000 + 1;
        int answer = Max;
        int[][] cost = new int[n][n];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if (i == j){
                    cost[i][j] = 0;
                }            
                else {
                    cost[i][j] = Max;
                }
            }
        }
        
        for(int[] fare : fares){
            cost[fare[0]-1][fare[1]-1] = fare[2];
            cost[fare[1]-1][fare[0]-1] = fare[2];
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < n ; k++){
                    cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
                }
            }
        }
        
        for(int i = 0 ; i < n ; i ++){
            answer = Math.min(answer, cost[s-1][i] + cost[i][a-1] + cost[i][b-1]);
        }
        
        
        return answer;
    }
}