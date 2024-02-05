import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

class Solution {
    public boolean jumpCheck(String word1, String word2){
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if(diffCount > 1) return false;
        }
        
        return true;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 1;
        boolean targetCheck = false;
        boolean beginCheck = false;
               
        Queue<int[]> queue = new LinkedList<>();
        Vector<Integer>[] jumps = new Vector[words.length];
        
        for(int i = 0 ; i < words.length ; i++){
            if(jumpCheck(begin,words[i])){
                beginCheck = true;
                queue.add(new int[] {i,0});
                
            }
            
            if(target.equals(words[i])){
                targetCheck = true;
            }
        }        
        
        if(beginCheck == false || targetCheck == false){
            return 0;
        }
        
        for(int i = 0 ; i < jumps.length ; i++){
            jumps[i] = new Vector<>();
        }
        
              
        for(int i = 0 ; i < words.length -1 ; i++){
            for(int j = i+1 ;  j < words.length ; j++){
                if(jumpCheck(words[i],words[j])){   
                    jumps[i].add(j);
                    jumps[j].add(i);
                }
            }
        }
    
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(words[cur[0]].equals(target)){
                return(cur[1]+1);
            }
            else{
                for(Integer num : jumps[cur[0]]){
                    queue.add(new int[]{num,cur[1]+1});
                }
                
            }
        }
  
        return answer;
    }
}