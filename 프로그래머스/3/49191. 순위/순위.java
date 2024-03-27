/*
1. 플로이드 와셜로 모든 연결선을 구한다.
2. 연결선의 개수가 n-1인 노드의 수가 정답


*/

class Solution {
    public static int[][] edge;
    public static int answer;
    
    public void initEdge(int n, int[][] results){
        edge = new int[n+1][n+1];
        
        for(int [] result : results){
            edge[result[0]][result[1]] = 1;
        }
    }
    
    public void FW(int n){
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                for(int k = 1 ; k <= n ; k++){
                    if(edge[i][k] == 1 && edge[k][j] == 1){
                        edge[i][j] = 1;
                    }
                }
            }
        }
    }
    
    public void getAnswer(int n){
        for(int i = 1 ; i <= n ; i++){
            int sum = 0;
            
            for(int j = 1 ; j <= n ; j++){
                sum += edge[i][j];
                sum += edge[j][i];
            }
            
            if(sum >= n - 1){
                answer++;
            }
        }
    }
    
    public int solution(int n, int[][] results) {
        answer = 0;
        
        initEdge(n, results);
        
        FW(n);
        
        FW(n);
        
        getAnswer(n);
        
        
        
        return answer;
    }
}