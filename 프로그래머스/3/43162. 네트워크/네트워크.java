import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0 ; i < computers.length ; i++){
            if(set.add(i) == false){
                continue;
            }
            

            answer++;
            queue.add(i);
            
            while(queue.isEmpty() == false){
                int num = queue.poll();

                
                for(int j = 0 ; j < computers[num].length ; j++){

                    if(computers[num][j] == 1 && set.add(j) == true){

                        queue.add(j);
                    }
                }
            }
            
            
        }
        return answer;
    }
}