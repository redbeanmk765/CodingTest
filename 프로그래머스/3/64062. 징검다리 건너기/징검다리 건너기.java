import java.util.Collections;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static int minNum;
    
    public int getMax(int[] stones, int index , int k){
        int max = 0;
        int next = 0;
        
        for(int i = index ; i < index + k ; i++ ){
            if(max < stones[i]){
                max = stones[i];
                next = i;
            }else if(max == stones[i]){
                next = i;
            }
        }
        
        //System.out.println(max);
        
        if(minNum > max){
            minNum = max;
            
        }else{
            //next = index + k - 1;
        }
        
        return next;
    }
    public int solution(int[] stones, int k) {
        minNum = 200000001;
        
       
        
        int count = 0;
    
        for(int i = 0 ; i <= (stones.length - k) ; ){
            int tmp = getMax(stones, i , k);
            i = tmp+1;
            count++;
            if(count > 3000) break;
        }
        
        getMax(stones, stones.length - k , k);
        
        if(stones.length == k){
            minNum = 0;
            for(int num : stones){
                if(minNum < num) minNum = num;
            }
        }
        return minNum;
    }
}