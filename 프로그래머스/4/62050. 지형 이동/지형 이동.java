/*
1. 우선순위큐를 사용하여 최소힙 구현. 사다리가 필요없으면 0 필요하면 그 값을 기준으로 최단거리 탐색
2. 탐색은 bfs와 유사. 모든 칸을 탐색하면 cost가 답
3. heap에 저장하기위해 class를 만들어야 하나? 
4. int[][] 2차원 배열로 방문점검 
*/

import java.util.PriorityQueue;
import java.util.Comparator;


class Solution {
    
    public static int[][] visit;
    public static PriorityQueue<int[]> heap;
    public static int[] dx;
    public static int[] dy;
    public static int sumHeight;
    
    public void init(int n){
        heap = new PriorityQueue<>(new Comparator<int []>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
        });
        
        visit = new int[n][n];
        
        dx = new int[] {1,0,-1,0};
        dy = new int[] {0,-1,0,1};
                           
    }
    
    public void search(int[][] land, int height){
        heap.add(new int[] {0, 0, 0});
        int count = 0;
        int max = land.length * land.length;
        
        while(true){
            if(heap.isEmpty()){
                break;
            }
            int[] cur = heap.poll();
            
            //System.out.println(cur[0] + " " + cur[1] + " " + cur[2] + " " + count);
            int cx = cur[0];
            int cy = cur[1];
            
            
            if(visit[cx][cy] == 1){
                continue;
            }
            
            sumHeight += cur[2];
            
            visit[cx][cy] = 1;  
            
            if(max == count) break;
            count++;
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= land.length || ny >= land.length || visit[nx][ny] != 0){
                    continue;
                }
                else{
                    int h = Math.abs(land[ny][nx] - land[cy][cx]);
                    
                    if(h <= height) h = 0;
                    
                    heap.add(new int[] {nx, ny, h});
                }
            }
            
            

        }
    }
    
    public int solution(int[][] land, int height) {
        
        init(land.length);

        search(land, height);
        
        for(int i = 0 ; i < 3; i++){
           // System.out.println(heap.poll()[2]);
        }
        
        

        
        return sumHeight;
    }
}