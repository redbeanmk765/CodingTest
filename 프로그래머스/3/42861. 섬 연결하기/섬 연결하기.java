import java.util.PriorityQueue;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Map<Integer, Vector<int[]>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        
        for(int i = 0 ; i < n ; i++){
            map.put(i, new Vector<>());
        }
        
        for(int[] cost : costs){
            map.get(cost[0]).add(new int[] {cost[1], cost[2]});
            map.get(cost[1]).add(new int[] {cost[0], cost[2]});
        }
        
        set.add(0);
        for(int[] bridge : map.get(0)){
            pq.add(bridge);
        }
        
        while(!pq.isEmpty()){
            int[] curBridge = pq.poll();
            if(set.add(curBridge[0])){
                answer += curBridge[1];
                                
                for(int[] bridge : map.get(curBridge[0])){
                    pq.add(bridge);
                }
            }
        }
        
        
        
        
        
        
        

        
        
        
        return answer;
    }
}