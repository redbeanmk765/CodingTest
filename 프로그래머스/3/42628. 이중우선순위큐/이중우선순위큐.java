import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> ascPQ = new PriorityQueue<>();
        PriorityQueue<Integer> dscPQ = new PriorityQueue<>((A,B)->B-A);
        
        for(String operation : operations){
            int num = Integer.parseInt(operation.substring(2));
            if(operation.charAt(0) == 'I'){
                ascPQ.add(num);
                dscPQ.add(num);
            }
            else{
                if(dscPQ.isEmpty()) continue;
                if(num == 1){
                    ascPQ.remove(dscPQ.poll());
                }
                else{
                    dscPQ.remove(ascPQ.poll());
                }
            }
        }
        
        if(dscPQ.isEmpty()) return new int[]{0,0};
        answer = new int[]{dscPQ.poll(), ascPQ.poll()};
        
        return answer;
    }
}