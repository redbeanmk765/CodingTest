import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> Pqueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works){
            Pqueue.add(work);
        }

        for(int i = 0 ; i < n; i++){
            int work = Pqueue.poll();
            if ( work == 0 ){ 
                return 0;
            }
            
            Pqueue.add(work - 1);
        }
    
        while (!Pqueue.isEmpty()) {
            answer += (Math.pow(Pqueue.poll(), 2));
        }

        return answer;
    }
}