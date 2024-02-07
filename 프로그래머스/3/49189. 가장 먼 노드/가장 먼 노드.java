import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int[] distance = new int[n];
        Arrays.fill(distance, 20001);
        distance[0] = 0;
        
        Vector<Integer>[] nodes = new Vector[n];
        for(int i = 0 ; i < nodes.length ; i++){
            nodes[i] = new Vector<>();
        }
        
        for(int[] vertex : edge){
            nodes[vertex[0]-1].add(vertex[1]-1);
            nodes[vertex[1]-1].add(vertex[0]-1);
        }
        
        queue.add(0);
        set.add(0);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(Integer next : nodes[cur]){
                if(distance[cur] + 1 < distance[next]){
                    distance[next] = distance[cur] + 1;
                }
                if(set.add(next)){
                    queue.add(next);
                }
            }
        }
        int far = 0;
        for(int dis : distance){
            if(far < dis){
                far = dis;
                answer = 1;
            }
            else if(far == dis){
                answer ++;
            }
        }
       
        
        return answer;
    }
}