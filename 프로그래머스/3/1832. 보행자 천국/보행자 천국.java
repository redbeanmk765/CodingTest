/*
1. dfs 보다는 dp를 사용해보자 
2. 자동차의 방향은 오른쪽, 아래로만 이동가능 > 즉 y축x축순으로 탐색하면됨
3. 기본 점화식은 dp[x][y] = dp[x-1][y] + dp[x][y-1]
4. 초기화시 0번째 줄은 미리 채우기
5. 못가는 길은 0으로, 일직선 방향은 한컨 더 이동 
6. null방지로 0번칸 만들어놓기
7. 왼쪽, 위쪽 방향을 저장하기 위해 3차원 배열 사용 왼쪽이 0 위쪽이 1
*/

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] map) {
        int answer = 0;
        
        
        int[][][] dp = new int[m][n][2];
        
        for(int x = 0 ; x < n ; x++){
            if(map[0][x] == 1) break;
            dp[0][x][0] = 1;
        }
        
        for(int y = 0 ; y < m ; y++){
            if(map[y][0] == 1) break;
            dp[y][0][1] = 1;
        }

        for(int y = 1 ; y < m ; y++){
            for(int x = 1 ; x < n ; x++){  
                
                if(map[y][x] == 1){ 
                    continue;
                }
                
                int left = dp[y][x-1][0];
                int up = dp[y-1][x][1];
                
                //위쪽이 단방향이 아님
                if(map[y-1][x] == 0){
                    up = (up + dp[y-1][x][0]) % MOD;
                }
                
                //왼쪽이 단방향이 아님
                if(map[y][x-1] == 0){
                    left = (left + dp[y][x-1][1]) % MOD;

                }
                
                dp[y][x][0] = left;
                dp[y][x][1] = up;
                
            }
        }
        
        answer = (dp[m-1][n-1][0] +dp[m-1][n-1][1])% MOD;
        return answer;
    }
}